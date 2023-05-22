//package com.hanex.starter.common.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);
//
//        if (header.isBlank()){
//            chain.doFilter(request,response);
//            return;
//        }
//
//    }
//
//
//    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
//        if (!tokenHeader.isBlank()) {
//
//            try {
//                byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();
//
//                Jws<Claims> parsedToken = Jwts.parser().setSigningKey(signingkey).parseClaimsJws(tokenHeader.replace("Bearer", ""));
//
//
//                Claims claims = parsedToken.getBody();
//
//                String loginId = (String) claims.get("loginId");
//
//                List<SimpleGrantedAuthority> authorities = ((List<?>) claims.get("role")).stream()
//                        .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
//
//                if (isNotEmpty(userId)) {
//                    User user = new User();
//                    user.setUsername(userId);
//                    user.setUser_id(userId);
//                    user.setLogin_id(loginId);
//                    user.setUser_nm(user_nm);
//                    user.setAuthorities((List<String>) claims.get("rol"));
//                    user.setMb_id(mb_id);
//                    CustomUser userDetails = new CustomUser(user);
//                    return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
//                }
//
//            } catch (ExpiredJwtException exception) {
//                log.warn("Request to parse expired JWT : {} failed : {}", tokenHeader, exception.getMessage());
//
//            } catch (UnsupportedJwtException exception) {
//                log.warn("Request to parse unsupported JWT : {} failed : {}", tokenHeader, exception.getMessage());
//
//            } catch (MalformedJwtException exception) {
//                log.warn("Request to parse invalid JWT : {} failed : {}", tokenHeader, exception.getMessage());
//
//            } catch (IllegalArgumentException exception) {
//                log.warn("Request to parse empty or null JWT : {} failed : {}", tokenHeader, exception.getMessage());
//
//            }
//
//        }
//        return null;
//
//    }
//
//}
