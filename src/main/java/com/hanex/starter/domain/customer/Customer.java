package com.hanex.starter.domain.customer;

import com.hanex.starter.domain.user.User;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("tb_customer")
public class Customer {

	@Id
	private UUID id;

	private AggregateReference<User, @NotNull UUID> managerId;

	@Column("id")
	private BankAccount bankAccount;

	private CustomerType customerType;

	private String memo;


	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

	@CreatedBy
	private AggregateReference<User, @NotNull UUID> createdBy;

	@LastModifiedBy
	private AggregateReference<User, @NotNull UUID> updatedBy;

	// ---------------- 비지니스 로직 --------------- //

}
