package com.fuji.notification_service.email;

import com.fuji.notification_service.kafka.order.OrderConfirmation;
import com.fuji.notification_service.kafka.payment.PaymentConfirmation;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.fuji.notification_service.email.EmailTemplate.ORDER_CONFIRMATION;
import static com.fuji.notification_service.email.EmailTemplate.PAYMENT_CONFIRMATION;
import static java.lang.String.format;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sentPaymentSuccessEmail(PaymentConfirmation payment) throws MessagingException {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper messageHelper= new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name()
        );

        messageHelper.setFrom("root.illivan@gmail.com");

        final String templateName= PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> variables= new HashMap<>();
        variables.put("customerName", payment.customerFirstname());
        variables.put("orderReference", payment.orderReference());
        variables.put("amount", payment.amount());

        Context context = new Context();
        context.setVariables(variables);

        messageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(payment.customerEmail());
            mailSender.send(mimeMessage);
            log.info(format("Payment confirmation email sent to: %s - with template: %s", payment.customerEmail(), templateName));

        } catch (MessagingException e) {
            log.warn("WARNING - cannot send payment confirmation email to {}", payment.customerEmail(), e);
        }
    }

    @Async
    public void sentOrderConfirmationEmail(OrderConfirmation order) throws MessagingException {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper messageHelper= new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name()
        );

        messageHelper.setFrom("root.illivan@gmail.com");

        final String templateName= ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> variables= new HashMap<>();
        variables.put("customerName", order.customer().firstname());
        variables.put("orderReference", order.orderReference());
        variables.put("totalAmount", order.amount());
        variables.put("products", order.products());

        Context context = new Context();
        context.setVariables(variables);

        messageHelper.setSubject(ORDER_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(order.customer().email());
            mailSender.send(mimeMessage);
            log.info(format("Payment confirmation email sent to: %s - with template: %s", order.customer().email(), templateName));

        } catch (MessagingException e) {
            log.warn("WARNING - cannot send payment confirmation email to {}", order.customer().email(), e);
        }
    }
}