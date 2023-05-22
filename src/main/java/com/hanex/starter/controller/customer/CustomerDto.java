package com.hanex.starter.controller.customer;

import com.hanex.starter.domain.customer.BankAccount;
import com.hanex.starter.domain.customer.Customer;
import lombok.*;

import java.util.UUID;

public class CustomerDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class SaveRequest {

		private String accountType;
		private String phone;

		private String managerName;
		private String ceoName;
		private String registrationNumber;

		private String memo;

		private String bank;
		private String accountNumber;
		private String accountUserName;
		private Boolean accountVerified;

		public Customer toEntity(){
			return Customer.builder()
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
	public static class CustomerInfoResponse {

		private String customerCode;
		private String accountType;
		private String phone;
		private String managerName;
		private String ceoName;
		private String registrationNumber;
		private String memo;


	}
}
