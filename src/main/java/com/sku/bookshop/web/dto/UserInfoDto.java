package com.sku.bookshop.web.dto;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.domain.user.Role;
import com.sku.bookshop.domain.user.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {

    @NotBlank(message = "아이디를 입력해주세요")
    private String id;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private String birth;

    private String zipCode;

    private String roadNameAddress;

    private String localNameAddress;

    private String detailAddress;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .address(setUserAddress())
                .type(Role.USER.getRole())
                .build();
    }

    public Address setUserAddress() {
        return Address.builder()
                .zipcode(zipCode)
                .roadNameAddress(roadNameAddress)
                .localNameAddress(localNameAddress)
                .detailAddress(detailAddress)
                .build();
    }

    public void setPasswordEncryption(String password) {
        this.password = password;
    }
}
