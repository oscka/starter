package com.hanex.starter.common.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.messages")
public class MessageProperties {

    private String basename;
    private String encoding;
    private int cacheDuration;
    private Boolean alwaysUseMessageFormat;
    private Boolean useCodeAsDefaultMessage;
    private Boolean fallbackToSystemLocale;
}
