package com.hanex.starter.product.event;

import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class ProductChangeEvent {

    private String eventType;
    private Long productId;
    private String productName;
    private int productStock;

    public ProductChangeEvent() {
        this.eventType = this.getClass().getSimpleName();
    }
}
