package com.sku.bookshop.domain.member;

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
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Long num;

    @Column
    private String userid;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String birth;

    @Embedded
    private Address address;

    @Column
    private String role;

    @Builder
    public Member(String userid, String password, String name, String email, String phoneNumber, String birth, Address address, String role) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.address = address;
        this.role = role;
    }

}
