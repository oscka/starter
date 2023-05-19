package com.hanex.starter.domain.owner;

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
@Table("tb_owner")
public class Owner {

	@Id
	private UUID id;

	private AggregateReference<User, @NotNull UUID> userId;

	@Column("id")
	private BankAccount bankAccount;

	private OwnerType ownerType;

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
