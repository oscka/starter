package com.hanex.starter.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Member 종류
 */
@RequiredArgsConstructor
@Getter
public enum MemberType implements EnumType{
    

    CLIENT("거래처"),
    EXECUTOR("실행사")
    ;

    private final String text;

    @Override
    public String getId() {
        return this.name();
    }


}
