package com.hanex.starter.customer.domain;

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
@Table("client")
public class Customer {

    @Id
    private UUID id;
    private BaseUser baseUser;
    private UserStatus customerStatus;
    private UserRole role;
    private String email;
    private Group group;
    private String name;
    private String phone;

}
