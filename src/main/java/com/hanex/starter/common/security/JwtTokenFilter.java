//package com.hanex.starter.common.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class JwtTokenFilter extends OncePerRequestFilter {
//
//    private JwtTokenProvider jwtTokenProvider;
//
//    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    /*
//        JWT인증 정보를 현재 SecurityContext에 저장
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//
//        String token = jwtTokenProvider.resolveToken(httpServletRequest);
//
//        try {
//            if (StringUtils.isNoneBlank(token) && jwtTokenProvider.validateToken(token)) {
//                Authentication auth = jwtTokenProvider.getAuthentication(token);
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        } catch (Exception e) {
//            SecurityContextHolder.clearContext();
//            log.error("ERROR > JWT Filter > {}",e.getMessage());
//        }
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//
//}
//
