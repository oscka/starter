package com.hanex.starter.order.service;

import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.order.domain.Order;
import com.hanex.starter.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(){

    }

    public void findByOrderId(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()->new Exception404("해당하는 주문을 찾을 수 없습니다."));
    }


}
