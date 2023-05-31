package com.hanex.starter.user.dto;

import java.util.UUID;

import com.hanex.starter.common.util.CommonEncoder;
import com.hanex.starter.common.enums.UserRole;
import com.hanex.starter.common.enums.UserStatus;
import com.hanex.starter.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;

public class UserDto{

	@Schema(description = "회원가입(사용자 정보 저장) 요청 DTO")
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SaveRequest {

		@Schema(description = "사용자 ID", nullable = false, example = "user1")
		@NotBlank(message = "{validation.notBlank.id}")
		private String loginId;

		@Schema(description = "사용자 이름", nullable = false, example = "홍길동")
		@NotBlank(message = "{validation.notBlank.name}")
		private String name;

		@Schema(description = "사용자 상태", nullable = false,  example = "ACTIVE")
		@NotNull
		private UserStatus userStatus;

		@Schema(description = "사용자 권한", nullable = false,  example = "ROLE_ADMIN")
		@NotNull
		private UserRole role;

		@Schema(description = "이메일", nullable = false,  example = "test@test.com")
		@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
		@NotBlank(message = "{validation.notBlank.email}")
		private String email;

		@Schema(description = "비밀번호", nullable = false,  example = "test1234")
		@NotBlank(message = "{validation.notBlank.password}")
		private String password;

		@Schema(description = "전화번호", example = "01012345678")
		private String phone;

		public User toEntity(){
			return User.builder()
					.id(UUID.randomUUID())
					.loginId(this.loginId)
					.name(this.name)
					.userStatus(this.userStatus)
					.phone(this.phone)
					.role(this.role)
					.password(new CommonEncoder().encode(this.password))
					//.email(new EncryptString(this.email))
					.email(this.email)
					.build();
		}

	}

	@Schema(description = "사용자 조회 응답 DTO")
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class UserInfoResponse {

		private String loginId;

		private String name;

		private UserStatus userStatus;

		private UserRole role;

		private String email;

		private String phone;

		private Instant createdAt;

	}


	@Schema(description = "사용자 수정 요청 DTO")
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class UpdateRequest {

		@Schema(description = "이름", nullable = false,  example = "홍길동")
		@NotBlank(message = "{validation.notBlank.name}")
		private String name;

		@Schema(description = "이메일", nullable = false,  example = "test@test.com")
		@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
		@NotBlank(message = "{validation.notBlank.email}")
		private String email;

		@Schema(description = "비밀번호", nullable = false,  example = "test1234")
		@NotBlank(message = "{validation.notBlank.password}")
		private String password;

		public User toEntity(){
			return User.builder()
					.name(this.name)
					.password(new CommonEncoder().encode(this.password))
					.email(this.email)
					.build();
		}

	}

	@Schema(description = "로그인 요청 DTO")
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class LoginRequest {

		@Schema(description = "사용자 ID", nullable = false, example = "user1")
		@NotBlank(message = "{validation.notBlank.id}")
		private String loginId;

		@Schema(description = "비밀번호", nullable = false,  example = "test1234")
		@NotBlank(message = "{validation.notBlank.password}")
		private String password;
	}

}