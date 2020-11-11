package com.sku.bookshop.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class  Address {

    private String zipCode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    @Builder
    public Address(String zipCode, String roadAddress, String jibunAddress, String detailAddress) {
        this.zipCode = zipCode;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.detailAddress = detailAddress;
    }
}
