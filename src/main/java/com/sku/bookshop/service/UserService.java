package com.sku.bookshop.service;

import com.sku.bookshop.domain.user.UserRepository;
import com.sku.bookshop.web.dto.UserInfoDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long userRegister(UserInfoDto infoDto) {

        infoDto.setPasswordEncryption(passwordEncoder.encode(infoDto.getPassword()));

        return repository.save(infoDto.toEntity()).getNum();
    }

}
