package com.sku.bookshop.web.dto;

import com.sku.bookshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDto {

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

    private String type;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .build();
    }
    @Builder
    public UserInfoDto(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    // 비밀번호 암호화
    public void encryptionPassword(String password) {
        this.password = password;
    }

    // 권한 설정
    public void setAuthorise(String key) {
        this.type = key;
    }
}
