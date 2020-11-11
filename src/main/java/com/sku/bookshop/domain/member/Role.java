package com.sku.bookshop.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    MEMBER("ROLE_MEMBER","일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String value;
}
