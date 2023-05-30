package com.hanex.starter.order.domain;

import com.hanex.starter.product.domain.Product;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
public class OrderLineItem {

    private Long orderId;
    private Long totalPrice;
    private Product product;

}
