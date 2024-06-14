package com.fuji.notification_service.email;

import com.fuji.notification_service.kafka.payment.PaymentConfirmation;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;

import static org.apache.http.protocol.HTTP.UTF_8;


@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sentPaymentSuccessEmail(String email, PaymentConfirmation payment) throws MessagingException {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper messageHelper= new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name()
        );

        messageHelper.setFrom("root.illivan@gmail.com");
    }
}
