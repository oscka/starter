package com.hanex.starter.order.service;

import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.order.domain.Order;
import com.hanex.starter.order.dto.OrderDto;
import com.hanex.starter.order.repository.OrderRepository;
import com.hanex.starter.product.event.ProductChanged;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(OrderDto.CreateOrderRequest request){
        orderRepository.save(request.toEntity());
    }

    public void findByOrderId(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()->new Exception404("해당하는 주문을 찾을 수 없습니다."));
    }




}
