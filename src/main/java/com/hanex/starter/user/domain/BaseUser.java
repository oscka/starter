package com.hanex.starter.user.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BaseUser {

    private String loginId;
    private String password;
    private String authId;

}
