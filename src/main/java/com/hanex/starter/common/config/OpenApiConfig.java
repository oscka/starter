package com.hanex.starter.common.config;

import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    /**
     * 1) API Grouping > ALL
     * @return
     */
    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("API ALL")
                .pathsToMatch("/**")
                .build();
    }

    /**
     * 2) API Grouping > Admin
     * @return
     */
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("ADMIN API")
                .pathsToMatch("/v1/admin/**")
                //.addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }

    /**
     * 3) API Grouping > User
     * @return
     */
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("USER API")
                .pathsToMatch("/v1/users/**")
                .build();
    }

    /**
     * 4) API Grouping > Member
     * @return
     */
    @Bean
    public GroupedOpenApi memberApi() {
        return GroupedOpenApi.builder()
                .group("Member API")
                .pathsToMatch("/v1/member/**")
                .build();
    }

    /**
     * 5) API Grouping > Customer
     * @return
     */
    @Bean
    public GroupedOpenApi customerApi() {
        return GroupedOpenApi.builder()
                .group("Customer API")
                .pathsToMatch("/v1/customer/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {

        // SecuritySecheme명
        String jwtSchemeName = "jwtAuth";
        // API 요청헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("bearer")
                        .bearerFormat("JWT")); // 토큰 형식을 지정하는 임의의 문자(Optional)


        Info info = new Info()
                .title("Starter API")
                .version("v1.0.0")
                .description("HanExpress Starter 프로젝트");

        return new OpenAPI()
                .addSecurityItem(securityRequirement)
                .components(components)
                .info(info);
    }



}