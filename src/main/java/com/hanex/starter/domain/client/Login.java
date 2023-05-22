package com.hanex.starter.domain.client;

import com.hanex.starter.common.util.encrypt.EncryptString;
import com.hanex.starter.domain.user.common.UserRole;
import com.hanex.starter.domain.user.common.UserState;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Login {

    private String loginId;

    private String password;

    private String authId;
}

