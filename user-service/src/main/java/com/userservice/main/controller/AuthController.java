package com.userservice.main.controller;

import com.userservice.main.service.AuthService;
import com.userservice.main.vo.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<String> userAuth(@RequestBody AuthRequest request){
        return ResponseEntity.ok().body(authService.userAuth(request));
    }
}
