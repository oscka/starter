package com.hanex.starter.customer.dto;

import com.hanex.starter.common.enums.Group;
import com.hanex.starter.common.enums.UserRole;
import com.hanex.starter.common.enums.UserStatus;
import com.hanex.starter.common.util.CommonEncoder;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.user.domain.BaseUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

public class CustomerDto {

    @Schema(description = "고객사 생성 요청 DTO")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class SaveRequest {

        @Schema(description = "로그인 ID", example = "user1")
        private String loginId;

        @Schema(description = "비밀번호", example = "test1234")
        private String password;

        @Schema(description = "고객사 계정 상태", example = "ACTIVE")
        private UserStatus customerStatus;

        @Schema(description = "고객사 그룹", example = "FINANCE")
        private Group customerGroup;

        @Schema(description = "이메일", example = "test@test.com")
        private String email;

        @Schema(description = "고객사명", example = "한익스프레스")
        private String name;

        @Schema(description = "휴대폰", example = "01012345678")
        private String phone;

        @Schema(description = "메모")
        private String memo;

        public Customer toEntity (){
            return Customer.builder()
                    .id(UUID.randomUUID())
                    .version(0L)
                    .customerStatus(this.customerStatus)
                    .baseUser(BaseUser.builder()
                            .loginId(this.loginId)
                            .password(new CommonEncoder().encode(this.password))
                            .userRole(UserRole.ROLE_CUSTOMER)
                            .build())
                    .email(this.email)
                    .memo(this.memo)
                    .customerGroup(this.customerGroup)
                    .name(this.name)
                    .phone(this.phone)
                    .build();
        }

    }

    @Schema(description = "고객사 조회 응답 DTO")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CustomerInfoResponse {

        @Schema(description = "고객사 고유번호")
        private UUID id;

        @Schema(description = "로그인 ID")
        private String loginId;

        @Schema(description = "고객사 계정 상태")
        private UserStatus customerStatus;

        @Schema(description = "고객사 권한")
        private UserRole role;

        @Schema(description = "이메일")
        private String email;
        
        @Schema(description = "메모")
        private String memo;

        @Schema(description = "고객사 그룹")
        private Group customerGroup;

        @Schema(description = "고객사명")
        private String name;

        @Schema(description = "휴대폰")
        private String phone;

        @Schema(description = "생성일")
        private Instant createdAt;

        @Schema(description = "수정일")
        private Instant updatedAt;
    }


    @Schema(description = "고객사 수정 요청 DTO")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class UpdateRequest {

        @Schema(description = "이메일")
        private String email;

        @Schema(description = "고객사 그룹")
        private Group customerGroup;

        @Schema(description = "고객사명")
        private String name;

        @Schema(description = "휴대폰")
        private String phone;

        @Schema(description = "메모")
        private String memo;
    }
}
