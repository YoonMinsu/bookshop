package com.sku.bookshop.web.dtos;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.domain.member.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@Getter
@Setter
public class MemberRequestDto {

    @NotBlank
    private String userid;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String birth;

    private String zipcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    public Member toEntity() {
        return Member.builder()
                .userid(userid)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .address(Address.builder()
                        .zipCode(zipcode)
                        .roadAddress(roadAddress)
                        .jibunAddress(jibunAddress)
                        .detailAddress(detailAddress)
                        .build())
                .role(Role.MEMBER.getKey())
                .build();
    }

    public void setEncryptionPassword(String password) {
        this.password = password;
    }
}
