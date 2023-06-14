package com.hanex.starter.product.event;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductChanged {

    @Builder.Default
    private String eventType = ProductChanged.class.getSimpleName();
    private Long productId;
    private String productName;
    private Integer productStock;

}
