package com.hanex.starter.customer.dto;

import com.hanex.starter.common.enums.Group;
import com.hanex.starter.common.enums.UserRole;
import com.hanex.starter.common.enums.UserStatus;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.user.domain.BaseUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

public class CustomerDto {

    @Schema(description = "고객사 생성 요청 DTO")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class SaveRequest {

        private String loginId;
        private String password;
        private UserStatus customerStatus;
        private String email;
        private Group group;
        private String name;
        private String phone;

        public Customer toEntity (){
            return Customer.builder()
                    .customerStatus(this.customerStatus)
                    .baseUser(BaseUser.builder()
                            .loginId(this.loginId)
                            .password(this.password)
                            .build())
                    .email(this.email)
                    .role(UserRole.ROLE_CUSTOMER)
                    .group(this.group)
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
        private UUID id;
        private BaseUser baseUser;
        private UserStatus customerStatus;
        private UserRole role;
        private String email;
        private Group group;
        private String name;
        private String phone;
    }


    @Schema(description = "고객사 수정 요청 DTO")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class UpdateRequest {
        private UserStatus customerStatus;
        private UserRole role;
        private String email;
        private Group group;
        private String name;
        private String phone;
    }
}
