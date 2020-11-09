package com.sku.bookshop.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String zipcode;

    private String roadNameAddress;

    private String localNameAddress;

    private String detailAddress;

    @Builder
    public Address(String zipcode, String roadNameAddress, String localNameAddress, String detailAddress) {
        this.zipcode = zipcode;
        this.roadNameAddress = roadNameAddress;
        this.localNameAddress = localNameAddress;
        this.detailAddress = detailAddress;
    }
}


