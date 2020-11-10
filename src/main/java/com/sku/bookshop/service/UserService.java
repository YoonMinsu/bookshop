package com.sku.bookshop.service;

import com.sku.bookshop.domain.user.Role;
import com.sku.bookshop.domain.user.UserRepository;
import com.sku.bookshop.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void userRegister(UserInfoDto infoDto) {
        // 권한 (일반 유저)
        infoDto.setAuthorise(Role.USER.getRole());

        // 비밀번호 암호화
        infoDto.encryptionPassword(passwordEncoder.encode(infoDto.getPassword()));

        repository.save(infoDto.toEntity());
    }
}
