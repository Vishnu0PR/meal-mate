package com.userservice.main.service.impl;

import com.userservice.main.entity.UserInfo;
import com.userservice.main.repository.UserInfoRepository;
import com.userservice.main.service.UserService;
import com.userservice.main.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final PasswordEncoder encoder;
    private final UserInfoRepository repository;

    @Override
    public Long saveUser(UserInfoVO userInfoVO) {
        userInfoVO.setPassword(encoder.encode(userInfoVO.getPassword()));
        return repository.save(mapper.map(userInfoVO, UserInfo.class)).getId();
    }
}
