package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.entities.Order;
import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.exception.OrderLineNotFoundException;
import com.fuji.order_service.kafka.OrderConfirmation;
import com.fuji.order_service.kafka.OrderProducer;
import com.fuji.order_service.mapper.OrderMapper;
import com.fuji.order_service.model.Customer;
import com.fuji.order_service.model.ProductPurchaseRequest;
import com.fuji.order_service.model.ProductPurchaseResponse;
import com.fuji.order_service.repositories.OrderRepository;
import com.fuji.order_service.utils.Response;
import com.fuji.order_service.webClient.WebClientCustomer;
import com.fuji.order_service.webClient.WebClientProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final WebClientCustomer webClientCustomer;
    private final WebClientProduct webClientProduct;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    @Override
    public Response create(OrderRequest request) {
        var customer= webClientCustomer.getCustomer(request.customerID());
        List<ProductPurchaseResponse> productPurchased = webClientProduct.purchaseProduct(request.products());

        Order order = orderRepository.save(orderMapper.mapToOrder(request));

        for (ProductPurchaseRequest purchaseRequest: request.products()) {
            orderLineService.create(
                    new OrderLineRequest(
                            order.getId(),
                            purchaseRequest.productID(),
                            purchaseRequest.quantity()
                    )
            );
        }

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        productPurchased
                )
        );

        log.info("order created successfully");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "order", orderMapper.mapToOrderResponse(order)
                ),
                "order created successfully"
        );
    }

    @Override
    public Response update(OrderRequest request) {
        return null;
    }

    @Override
    public Response get(String idOrder) {
        Order order = orderRepository.findById(idOrder)
                .orElseThrow(() -> new OrderLineNotFoundException(
                        String.format("Order with id %s not found", idOrder)
                ));

        log.info("order by id {} getted successfully!", idOrder);
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "order", orderMapper.mapToOrderResponse(order)
                ),
                "order getted successfully!"
        );
    }

    @Override
    public Response getAll() {
        List<Order> allOrder = orderRepository.findAll();

        if (allOrder.isEmpty()) {
            log.error("Order is empty");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "there is no order into the database "
            );
        }

        log.info("all order getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "orders", allOrder.stream()
                                .map(orderMapper::mapToOrderResponse)
                                .toList()
                ),
                "all order getted successfully!"
        );
    }

    @Override
    public Response delete(String idOrder) {
        if (!orderRepository.existsById(idOrder)) {
            log.error("order with the id: {} does not exist!", idOrder);
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "order with the id: "+idOrder+" does not exist!"
            );
        }

        orderRepository.deleteById(idOrder);
        log.info("order with id {} deleted successfully!", idOrder);
        return generateResponse(
                HttpStatus.OK,
                null,
                "order with id: "+idOrder+" deleted successfully!"
        );
    }

    private Response generateResponse(HttpStatus status, Map<?, ?> data, String message) {
        return Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .data(data)
                .message(message)
                .build();
    }
}
