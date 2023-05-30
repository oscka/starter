package com.hanex.starter.order;

import com.hanex.starter.common.enums.OrderStatus;
import com.hanex.starter.member.Member;
import com.hanex.starter.user.domain.User;
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
