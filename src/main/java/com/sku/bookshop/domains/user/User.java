package com.sku.bookshop.domains.user;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    // 기본키
    private Long num;

    // 아이디
    @Column(nullable = false, length = 20)
    private String id;

    // 비밀번호
    @Column(nullable = false, length = 20)
    private String password;

    // 이름
    @Column(nullable = false, length = 10)
    private String name;

    // 이메일
    @Column(nullable = false, length = 20)
    private String email;

    // 생년월일
    @Column(nullable = false, length = 10)
    private String birth;

    @Embedded
    private Address address;

    @Builder
    public User(String id, String password, String name, String email, String birth, Address address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.address = address;
    }
}
