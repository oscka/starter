package com.hanex.starter.common.security;

public class SecurityConstants {

    public static final String JWT_SECRET = "hanexSecretKey"; // 64bit

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String TOKEN_TYPE = "JWT";

    public static final String TOKEN_ISSUER = "auth-service";

    public static final String TOKEN_AUDIENCE = "rest-app";

    public static final String AUTH_LOGIN_URL = "/auth";
}
