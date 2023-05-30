package com.hanex.starter.order;

import com.hanex.starter.common.enums.OrderStatus;
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
