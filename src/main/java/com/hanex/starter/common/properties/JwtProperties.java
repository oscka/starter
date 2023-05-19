package com.hanex.starter.common.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String privateKeyPath;
    private String publicKeyPath;
    private String issuer;
    private long tokenExpireLength;
    private long refreshTokenExpireLength;
}
