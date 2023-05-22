package com.hanex.starter.domain;

import com.hanex.starter.common.util.encrypt.EncryptString;
import com.hanex.starter.domain.user.common.UserRole;
import com.hanex.starter.domain.user.common.UserState;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BaseUser {

    private String loginId;

    private String name;

    private UserState state;

    private UserRole role;

    private EncryptString email;

    private String password;

    private String phone;
}
