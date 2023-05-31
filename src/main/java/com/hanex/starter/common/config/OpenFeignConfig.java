package com.hanex.starter.common.config;

import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages ="com.hanex.starter")
@Configuration
public class OpenFeignConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 2000, 3);
    }


}
