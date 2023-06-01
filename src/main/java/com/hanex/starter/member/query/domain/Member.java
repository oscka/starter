package com.hanex.starter.member.query.domain;

import com.hanex.starter.common.enums.MemberType;
import com.hanex.starter.common.enums.UserStatus;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.member.query.dto.MemberDto;
import com.hanex.starter.user.domain.BaseUser;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@EqualsAndHashCode(of = "id")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("member_tb")
public class Member {

	@Id
	private String id;

	private AggregateReference<Customer, @NotNull String> customerId;

	@Valid
	@Column("user_id")
	private BaseUser baseUser;

	// TODO :: BaseUser 로 옮기는게 더 나을지 고민..
	private UserStatus memberStatus;

	private MemberType memberType;

	private String memberCode;

	private String managerName;

	private String ceoName;

	private String registrationNumber;

	private String phone;

	private String memo;
	private String email;

	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

	@CreatedBy
	private AggregateReference<Customer, @NotNull String> createdBy;

	@LastModifiedBy
	private AggregateReference<Customer, @NotNull String> updatedBy;

	// ---------------- 비지니스 로직 --------------- //

	public MemberDto.MemberResponse toDto(){
		return MemberDto.MemberResponse.builder()
				.id(this.id)
				.email(this.email)
				.memberType(this.memberType)
				.memberCode(this.memberCode)
				.managerName(this.managerName)
				.ceoName(this.ceoName)
				.registrationNumber(this.registrationNumber)
				.phone(this.phone)
				.memo(this.memo)
				.build();
	}

}
