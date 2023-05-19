package com.hanex.starter.domain.order.common;

public enum OrderStatus {
	STORE, // 입고
	RELEASE, //출고
	INVENTORY, //재고
	PROCESS, //가공
	
	CANCELLED // 주문 취소됨

}
