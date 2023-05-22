package com.hanex.starter.common.properties;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String privateKeyPath;
    private String publicKeyPath;
    private String issuer;
    private long tokenExpireLength;
    private long refreshTokenExpireLength;
}
