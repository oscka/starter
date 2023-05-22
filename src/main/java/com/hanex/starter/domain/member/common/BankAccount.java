package com.hanex.starter.domain.member.common;

import lombok.*;
import org.springframework.data.annotation.Id;
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BankAccount {

	@Id
	private Long id;

	private String accountNumber;

	private String bank;

	private String accountUserName;

	private Boolean accountVerified;

}
