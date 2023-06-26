package com.userservice.main.service;

import com.userservice.main.vo.UserInfoVO;

public interface UserService {
    Long saveUser(UserInfoVO userInfoVO);
}
