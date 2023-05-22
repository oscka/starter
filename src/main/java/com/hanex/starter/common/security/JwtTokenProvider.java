//package com.hanex.starter.common.security;
//
//
//import com.hanex.starter.common.properties.JwtProperties;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.Base64;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Component
//@Slf4j
//public class JwtTokenProvider {
//
//    private final CustomUserDetails customUserDetails;
//
//    private final JwtProperties jwtProperties;
//
//
//    PrivateKey privateKey;
//    PublicKey publicKey;
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//    public static final String BEARER_PREFIX = "Bearer ";
//
//    @PostConstruct
//    protected void init() throws Exception {
//        privateKey = RSAUtils.getPrivateKey(jwtProperties.getPrivateKeyPath());
//        publicKey = RSAUtils.getPublicKey(jwtProperties.getPublicKeyPath());
//    }
//
//    public long getValidityInMilliseconds(TokenType tokenType) {
//        switch (tokenType) {
//            case AccessToken:
//                return jwtProperties.getTokenExpireLength();
//            case RefreshToken:
//                return jwtProperties.getRefreshTokenExpireLength();
//            default:
//                throw new RuntimeException("토큰 타입 불일치");
//        }
//    }
//
//    private static String createJTI() {
//        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
//    }
//
//    public String resolveToken(HttpServletRequest httpServletRequest) {
//        String bearerToken = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
//        if (StringUtils.isNoneBlank(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    public Boolean validateToken(String token) {
//        String username = getUsernameFromToken(token, publicKey);
//        if (username == null) return false;
//        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token, publicKey));
//    }
//
//    public Authentication getAuthentication(String token) {
//        String username = getUsernameFromToken(token, publicKey);
//        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getTokenType(String token) {
//        String tokenType;
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            tokenType = (String) claims.get("token-type");
//        } catch (Exception e) {
//            tokenType = null;
//        }
//        return tokenType;
//    }
//
//
//    private Boolean isTokenExpired(String token, PublicKey publicKey) {
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private String getUsernameFromToken(String token, PublicKey publicKey) {
//        String username;
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            username = claims.getSubject();
//        } catch (Exception e) {
//            username = null;
//        }
//        return username;
//    }
//
//    private Claims getClaimsFromToken(String token, PublicKey publicKey) {
//        Claims claims;
//        try {
//            claims = Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token).getBody();
//        } catch (ExpiredJwtException jwtException) {
//            log.error(jwtException.getMessage());
//            throw new RuntimeException( "만료된 엑세스 토큰입니다.");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            throw new RuntimeException("로그인 정보를 다시 확인하세요");
//        }
//        return claims;
//    }
//
//    public void KeyGenerator(String publickeyPath, String privateKeyPath, String jwkFileName, String secret) {
//        try {
//            RSAUtils.generateKey(publickeyPath, privateKeyPath, jwkFileName, secret, 2048);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public LinkedHashMap<String, Object> getParticipantInfoFromToken(String token) {
//        LinkedHashMap<String, Object> pinfo = null;
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            pinfo = (LinkedHashMap<String, Object>) claims.get("participantInfo");
//        } catch (Exception e) {
//            pinfo = null;
//        }
//        return pinfo;
//    }
//
//    public String getTokenID(String token) {
//        try {
//            return getClaimsFromToken(token, publicKey).getId();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public long getExpiredTime(String token) {
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            return claims.getExpiration().getTime();
//        } catch (Exception e) {
//            throw new RuntimeException("토큰 타입 불일치");
//        }
//    }
//}
//
