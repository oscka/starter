package com.hanex.starter.member.command.dto;

import com.hanex.starter.common.enums.MemberType;
import com.hanex.starter.member.command.domain.Member;
import lombok.*;

import java.util.UUID;

public class MemberDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class SaveRequest {

		private MemberType memberType;
		private String managerName;
		private String ceoName;
		private String registrationNumber;
		private String phone;
		private String memo;


		public Member toEntity(){
			return Member.builder()
					.memberType(this.memberType)
					.managerName(this.managerName)
					.ceoName(this.ceoName)
					.registrationNumber(this.registrationNumber)
					.phone(this.phone)
					.memo(this.memo)
					.build();
		}
	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class MemberInfoResponse {

		private UUID id;
		private String memberCode; // memberCode > 자동생성
		private MemberType memberType;
		private String managerName;
		private String ceoName;
		private String registrationNumber;
		private String phone;
		private String memo;
	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class UpdateRequest {

		private MemberType memberType;
		private String managerName;
		private String ceoName;
		private String registrationNumber;
		private String phone;
		private String memo;


		public Member toEntity(){
			return Member.builder()
					.memberType(this.memberType)
					.managerName(this.managerName)
					.ceoName(this.ceoName)
					.registrationNumber(this.registrationNumber)
					.phone(this.phone)
					.memo(this.memo)
					.build();
		}
	}
}
