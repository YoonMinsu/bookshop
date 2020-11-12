package com.sku.bookshop.domain.member;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.common.BaseEntity;
import com.sku.bookshop.domain.board.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseEntity implements UserDetails {

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

    @OneToMany(mappedBy = "member" ,cascade = CascadeType.ALL)
    private final List<Board> boardList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Role.MEMBER.getKey()));
    }

    @Override
    public String getUsername() {
        return userid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
