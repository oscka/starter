package com.hanex.starter.member;

import com.hanex.starter.customer.Customer;
import com.hanex.starter.common.enums.MemberType;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("member_tb")
public class Member {

	@Id
	private UUID id;
	private AggregateReference<Customer, @NotNull UUID> clientId;
	private MemberType memberType;
	private String memberCode;
	private String managerName;
	private String ceoName;
	private String registrationNumber;
	private String phone;
	private String memo;

	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

	@CreatedBy
	private AggregateReference<Customer, @NotNull UUID> createdBy;

	@LastModifiedBy
	private AggregateReference<Customer, @NotNull UUID> updatedBy;

	// ---------------- 비지니스 로직 --------------- //

	public MemberDto.MemberInfoResponse toDto(){
		return MemberDto.MemberInfoResponse.builder()
				.id(this.id)
				.memberCode(this.memberCode)
				.managerName(this.managerName)
				.ceoName(this.ceoName)
				.registrationNumber(this.registrationNumber)
				.phone(this.phone)
				.memo(this.memo)
				.build();
	}

}
