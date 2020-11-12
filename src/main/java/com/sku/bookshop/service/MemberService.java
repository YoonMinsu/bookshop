package com.sku.bookshop.service;

import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.domain.member.MemberRepository;
import com.sku.bookshop.web.dtos.member.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(MemberRequestDto requestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        requestDto.setEncryptionPassword(passwordEncoder.encode(requestDto.getPassword()));
        return memberRepository.save(requestDto.toEntity()).getNum();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserid(username);

        if (member != null) {
            return member;
        }
        throw new UsernameNotFoundException("member" + username + "not found");
    }
}
