package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.exception.OrderLineNotFoundException;
import com.fuji.order_service.mapper.OrderLineMapper;
import com.fuji.order_service.repositories.OrderLineRepository;
import com.fuji.order_service.utils.Response;
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
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    @Override
    public Response create(OrderLineRequest request) {
        OrderLine orderLine = orderLineMapper.mapToOrderLine(request);
        orderLineRepository.save(orderLine);

        log.info("new order line created!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                      "orderLine", orderLineMapper.mapToOrderLineResponse(orderLine)
                ),
                "new order line created!"
        );
    }

    @Override
    public Response update(OrderLineRequest request) {
        return null;
    }

    @Override
    public Response get(String idOrderLine) {
        OrderLine orderLine = orderLineRepository.findById(idOrderLine)
                .orElseThrow(() -> new OrderLineNotFoundException(
                        String.format("Order line with id %s not found", idOrderLine)
                ));

        log.info("order line by id {} getted successfully!", idOrderLine);
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "orderLine", orderLineMapper.mapToOrderLineResponse(orderLine)
                ),
                "order line getted successfully!"
        );
    }

    @Override
    public Response getAllByOrderId(String orderId) {
        List<OrderLine> allByOrderId = orderLineRepository.findAllByOrderId(orderId);

        if (allByOrderId.isEmpty()) {
            log.error("Order line with order id {} not found!", orderId);
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "there is no order line with order id " + orderId
            );
        }

        log.info("all order line with id {} getted successfully!", orderId);
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "orderLines", allByOrderId.stream()
                                .map(orderLineMapper::mapToOrderLineResponse)
                                .toList()
                ),
                "all order line with id: "+orderId+" getted successfully!"
        );
    }

    @Override
    public Response getAll() {
        List<OrderLine> allOrder = orderLineRepository.findAll();

        if (allOrder.isEmpty()) {
            log.error("Order line is empty");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "there is no order line into the database "
            );
        }

        log.info("all order line getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "orderLines", allOrder.stream()
                                .map(orderLineMapper::mapToOrderLineResponse)
                                .toList()
                ),
                "all order line getted successfully!"
        );
    }

    @Override
    public Response delete(String idOrderLine) {
        if (!orderLineRepository.existsById(idOrderLine)) {
            log.error("orderLine with the id: {} does not exist!", idOrderLine);
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "orderLine with the id: "+idOrderLine+" does not exist!"
            );
        }

        orderLineRepository.deleteById(idOrderLine);
        log.info("order line with id {} deleted successfully!", idOrderLine);
        return generateResponse(
                HttpStatus.OK,
                null,
                "order line with id: "+idOrderLine+" deleted successfully!"
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
