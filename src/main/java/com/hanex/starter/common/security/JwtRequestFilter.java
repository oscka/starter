package com.hanex.starter.common.security;

import com.hanex.starter.domain.user.User;
import com.hanex.starter.domain.user.common.UserRole;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {

        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);

        if (header.isBlank()){
            filter.doFilter(request,response);
            return;
        }

        Authentication authentication = this.getAuthentication(header);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filter.doFilter(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {

        if (tokenHeader.isBlank()) {
            return null;
        }

        try {
            byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();

            Jws<Claims> parsedToken = Jwts.parser().setSigningKey(signingkey)
                    .parseClaimsJws(tokenHeader.replace(SecurityConstants.TOKEN_PREFIX, ""));

            Claims claims = parsedToken.getBody();

            String loginId = (String) claims.get("loginId");

            if (!loginId.isBlank()) {

                List<SimpleGrantedAuthority> authorities = ((List<?>) claims.get("role")).stream()
                        .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());

                //List<String> roleList = (List<String>) claims.get("role");

                //String role = (String) claims.get("role");

                UserRole role = (UserRole) claims.get("role");

                User user = User.builder()
                        .loginId(loginId)
                        .password("")
                        .role(role)
                        .build();

                return new UsernamePasswordAuthenticationToken(new CustomUser(user), null, authorities);
            }

        } catch (ExpiredJwtException exception) {
            log.warn("Request to parse expired JWT : {} failed : {}", tokenHeader, exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            log.warn("Request to parse unsupported JWT : {} failed : {}", tokenHeader, exception.getMessage());
        } catch (MalformedJwtException exception) {
            log.warn("Request to parse invalid JWT : {} failed : {}", tokenHeader, exception.getMessage());
        } catch (IllegalArgumentException exception) {
            log.warn("Request to parse empty or null JWT : {} failed : {}", tokenHeader, exception.getMessage());
        }

        return null;

    }

}