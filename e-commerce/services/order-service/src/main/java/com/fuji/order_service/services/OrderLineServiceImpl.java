package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.mapper.OrderLineMapper;
import com.fuji.order_service.mapper.OrderMapper;
import com.fuji.order_service.repositories.OrderLineRepository;
import com.fuji.order_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        return null;
    }

    @Override
    public Response getAllByOrderId(String orderId) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }

    @Override
    public Response delete(String idOrderLine) {
        return null;
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
