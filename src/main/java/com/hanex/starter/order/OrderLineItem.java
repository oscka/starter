package com.hanex.starter.order;

import com.hanex.starter.product.Product;
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
