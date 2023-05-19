package com.hanex.starter.controller.product;

import lombok.*;

import java.util.UUID;

public class ProductDto {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class SaveRequest {
        private String name;
        private Long price;
        private String description;
        private UUID ownerId;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class ProductInfoResponse {
        private String name;
        private Long price;
        private String description;
        private UUID ownerId;
    }


}
