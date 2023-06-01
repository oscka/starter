package com.hanex.starter.user.domain;

import com.hanex.starter.common.enums.UserRole;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class BaseUser {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

    @NotNull
    private UserRole userRole;

}
