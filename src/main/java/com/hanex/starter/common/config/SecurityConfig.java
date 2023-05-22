package com.hanex.starter.common.config;

import com.hanex.starter.common.security.FilterResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CorsConfig corsConfig;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. CSRF 해제
        http.csrf().disable();

        // 2. jSessionId 사용 거부 (STATELESS 로 설정하면 쿠키에 세션키를 저장하지 않는다.)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 3. form 로그인 해제 (UsernamePasswordAuthenticationFilter 비활성화)
        http.formLogin().disable();

        // 4. 로그인 인증창이 뜨지 않게 비활성화
        http.httpBasic().disable();

        // 5. 커스텀 필터 등록 (security filter 교환)
        http.apply(new CustomSecurityFilterManager());

        // 6. 인증 실패 처리
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            log.warn("인증되지 않은 사용자가 resource 접근 : {}",authException.getMessage());
            FilterResponseUtil.unAuthorized(response, new RuntimeException("인증되지 않았습니다"));
        });

        // 7. 권한 실패 처리
        http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
            log.warn("권한이 없는 사용자가 resource 접근 : {}",accessDeniedException.getMessage());
            FilterResponseUtil.forbidden(response, new RuntimeException("권한이 없습니다"));
        });

        // h2-console
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
        http.headers().frameOptions().sameOrigin();

        // path setting
        http
            .authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .and()
            .authorizeRequests().antMatchers("/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/h2-console/**").permitAll();

        return http.build();
    }

    public class CustomSecurityFilterManager extends AbstractHttpConfigurer<CustomSecurityFilterManager, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                .addFilter(corsConfig.corsFilter());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
