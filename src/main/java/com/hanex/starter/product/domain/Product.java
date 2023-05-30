package com.hanex.starter.product.domain;


import com.hanex.starter.member.command.domain.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Builder
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Table("product_tb")
public class Product {

	private Long id;
	private String name;
	private Long price;
	private String description;

	private AggregateReference<Member, @NotBlank @Size(max = 200) String> ownerId;


	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

}
