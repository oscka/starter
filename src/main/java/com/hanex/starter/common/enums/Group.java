package com.hanex.starter.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Group implements EnumType{

    // 재무 CSR 재고 기획
    FINANCE("재무"),
    CSR("CSR"),
    INVENTORY("재고"),
    PROJECT("기획")
    ;

    private final String text;

    @Override
    public String getId() {
        return this.name();
    }
}
