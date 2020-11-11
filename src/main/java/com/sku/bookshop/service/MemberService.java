package com.sku.bookshop.service;


import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.domain.member.MemberRepository;
import com.sku.bookshop.domain.member.Role;
import com.sku.bookshop.web.dtos.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveMember(MemberRequestDto requestDto) {

        requestDto.setEncryptionPassword(passwordEncoder.encode(requestDto.getPassword()));

        return memberRepository.save(requestDto.toEntity()).getNum();
    }

}
