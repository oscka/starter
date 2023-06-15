package com.hanex.starter.common.config;

import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

@EnableFeignClients(basePackages ="com.hanex.starter")
@Configuration
public class OpenFeignConfig {


    @Bean
    public Retryer retryer() {
        // 재시도는 1초를 시작으로, 최대 2초로 재시도하고, 최대 3번을 재시도한다.
        return new Retryer.Default(1000, 2000, 3);
    }

    @Bean
    public FeignFormatterRegistrar dateTimeFormatterRegistrar() {
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }


}
