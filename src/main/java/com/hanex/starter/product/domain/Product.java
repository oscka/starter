package com.hanex.starter.product.domain;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanex.starter.common.enums.TableStatus;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.member.domain.Member;
import com.hanex.starter.product.dto.ProductDto;
import com.hanex.starter.product.event.ProductChangeEvent;
import com.hanex.starter.product.event.StreamProcessor;
import com.hanex.starter.user.domain.BaseUser;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * 상품
 */
@Builder
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Table("product_tb")
public class Product {

	@Id
	private Long id;

	private String name;

	private Integer quantity;

	private String description; // 상품 설명

	private String productCode; // 상품코드

	private Integer stock; // 재고

	private TableStatus productStatus; // 상품 활성화 여부


	private AggregateReference<Customer, @NotBlank @Size(max = 200) String> customerId;  // 고객 아이디
	private AggregateReference<Member, @NotBlank @Size(max = 200) String> supplyCompanyId; // 공급사 아이디

	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

	@CreatedBy
	private AggregateReference<BaseUser,@NotBlank String> createdBy;

	@LastModifiedBy
	private AggregateReference<BaseUser,@NotBlank String> updatedBy;

	public ProductDto.ProductInfoResponse toDto(){
		return ProductDto.ProductInfoResponse.builder()
				.id(id)
				.productCode(productCode)
				.productStatus(productStatus)
				.name(name)
				.description(description)
				.supplyCompanyId(supplyCompanyId.getId())
				.customerId(customerId.getId())
				.createdAt(createdAt)
				.createdBy(String.valueOf(this.createdBy.getId()))
				.updatedAt(updatedAt)
				.updatedBy(String.valueOf(this.updatedBy.getId()))
				.build();
	}

	// ---------------- 비지니스 로직 ---------------------------
	public void delete(){
		this.productStatus = TableStatus.N;
	}


}
