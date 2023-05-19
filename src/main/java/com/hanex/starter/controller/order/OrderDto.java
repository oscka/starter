package com.hanex.starter.controller.order;

import com.hanex.starter.domain.order.common.OrderStatus;
import lombok.*;

public class OrderDto {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class CreateOrderRequest {

        private OrderStatus status;

    }

}
