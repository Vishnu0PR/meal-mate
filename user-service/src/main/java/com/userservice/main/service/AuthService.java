package com.userservice.main.service;

import com.userservice.main.vo.AuthRequest;

public interface AuthService {

    String userAuth(AuthRequest request);
}
