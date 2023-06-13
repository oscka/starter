package com.hanex.starter.order.dto;

import com.hanex.starter.common.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;

public class OrderDto {


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class CreateOrderRequest {

        @Schema(description = "주문상태",example = "스테이크볶음밥")
        private OrderStatus orderStatus;

        @Schema(description = "주문상태",example = "스테이크볶음밥")
        private String customerId;

        @Schema(description = "주문상태",example = "스테이크볶음밥")
        private Instant orderDateTime;

        @Schema(description = "주문상태",example = "스테이크볶음밥")
        private Long productId;

        @Schema(description = "주문상태",example = "스테이크볶음밥")
        private Integer quantity;

    }


}
