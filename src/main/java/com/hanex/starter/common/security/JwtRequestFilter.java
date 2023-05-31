package com.hanex.starter.common.security;

import com.hanex.starter.user.domain.User;
import com.hanex.starter.common.enums.UserRole;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author jinseul
 * JWT 토큰 유효성 검사 및 SecurityContextHolder 생성
 */
@Slf4j
public class JwtRequestFilter extends BasicAuthenticationFilter {

    public JwtRequestFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {

        if (request.getRequestURI().contains("swagger") || request.getRequestURI().contains("/v3/api-docs")){
            filter.doFilter(request,response);
            return;
        }

        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);

        if (header.isBlank()){
            filter.doFilter(request,response);
            return;
        }


        try {
            byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();

            Jws<Claims> parsedToken = Jwts.parser().setSigningKey(signingkey)
                    .parseClaimsJws(header.replace(SecurityConstants.TOKEN_PREFIX, ""));

            Claims claims = parsedToken.getBody();

            String loginId = (String) claims.get("loginId");
            String role = (String) claims.get("role");
            if (StringUtils.hasLength(loginId) && StringUtils.hasLength(role)) {

                //List<String> roleList = (List<String>) claims.get("role");
                //List<SimpleGrantedAuthority> authorities = ((List<?>) claims.get("role")).stream().map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());

                User user = User.builder()
                        .loginId(loginId)
                        .role(UserRole.valueOf(role))
                        .build();

                CustomUser myUserDetails = new CustomUser(user);

                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                myUserDetails,
                                myUserDetails.getPassword(),
                                myUserDetails.getAuthorities()
                        );
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

        } catch (ExpiredJwtException exception) {
            log.warn("Request to parse expired JWT : {} failed : {}", header, exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            log.warn("Request to parse unsupported JWT : {} failed : {}", header, exception.getMessage());
        } catch (MalformedJwtException exception) {
            log.warn("Request to parse invalid JWT : {} failed : {}", header, exception.getMessage());
        } catch (IllegalArgumentException exception) {
            log.warn("Request to parse empty or null JWT : {} failed : {}", header, exception.getMessage());
        } finally {
            filter.doFilter(request, response);
        }
    }

}