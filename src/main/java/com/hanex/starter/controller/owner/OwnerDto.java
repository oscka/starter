package com.hanex.starter.controller.owner;

import com.hanex.starter.domain.owner.BankAccount;
import com.hanex.starter.domain.owner.Owner;
import lombok.*;

import java.util.UUID;

public class OwnerDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class SaveRequest {

		private UUID userId;
		private String memo;
		private String bank;
		private String accountNumber;
		private String accountUserName;
		private Boolean accountVerified;

		public Owner toEntity(){
			return Owner.builder()
					.bankAccount(BankAccount.builder()
							.bank(this.bank)
							.accountNumber(this.accountNumber)
							.accountUserName(this.accountUserName)
							.accountVerified(this.accountVerified)
							.build())

					.build();
		}

	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class OwnerInfoResponse {

		private UUID id;
		private String name;
		private String phone;
		private String registrationNumber;
	}
}
