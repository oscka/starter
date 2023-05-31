package com.hanex.starter.customer.domain;

import com.hanex.starter.customer.dto.CustomerDto;
import com.hanex.starter.user.domain.BaseUser;
import com.hanex.starter.common.enums.Group;
import com.hanex.starter.common.enums.UserRole;
import com.hanex.starter.common.enums.UserStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Builder
@Getter
@ToString
@Table("customer")
public class Customer {

    @Id
    private UUID id;
    private BaseUser baseUser;
    private UserStatus customerStatus;
    @Builder.Default
    private UserRole role = UserRole.ROLE_CUSTOMER;
    private String email;
    private Group group;
    private String name;
    private String phone;

    public CustomerDto.CustomerInfoResponse toDto(){
        return CustomerDto.CustomerInfoResponse.builder()
                .id(this.id)
                .customerStatus(this.customerStatus)
                .role(this.role)
                .email(this.email)
                .name(this.name)
                .phone(this.phone)
                .group(this.group)
                .build();
    }

}
