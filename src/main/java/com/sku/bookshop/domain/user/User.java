package com.sku.bookshop.domain.user;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.common.BaseEntity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private Long num;

    private String id;


    private String password;


    private String name;


    private String email;


    private String phoneNumber;


    private String birth;

    @Embedded
    private Address address;

    private String type;

    @Builder
    public User(String id, String password, String name, String email, String phoneNumber, String birth, Address address, String type) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.address = address;
        this.type = type;
    }
}
