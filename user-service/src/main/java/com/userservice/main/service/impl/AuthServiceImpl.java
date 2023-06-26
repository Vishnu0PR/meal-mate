package com.userservice.main.service.impl;

import com.userservice.main.repository.UserInfoRepository;
import com.userservice.main.security.jwt.JWTService;
import com.userservice.main.service.AuthService;
import com.userservice.main.vo.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserInfoRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    @Override
    public String userAuth(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()));
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));
        return jwtService.generateToken(user.getEmail());
    }


}
