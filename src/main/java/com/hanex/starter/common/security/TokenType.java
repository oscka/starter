package com.hanex.starter.common.security;

public enum TokenType {
    RefreshToken("REFRESH"),
    AccessToken("ACCESS");
    private final String type;

    TokenType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}