package com.hanex.starter.domain.order;

import com.hanex.starter.domain.order.common.OrderStatus;
import com.hanex.starter.domain.member.Member;
import com.hanex.starter.domain.user.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table("order_tb")
public class Order {

	@Id
	private Long id;
	private List<OrderLineItem> orderLineItems;
	private User user;
	private Member member;
	private OrderStatus status;
	private Instant orderDateTime;
}
