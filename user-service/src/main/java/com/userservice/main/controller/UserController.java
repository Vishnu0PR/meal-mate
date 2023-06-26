package com.userservice.main.controller;


import com.userservice.main.service.UserService;
import com.userservice.main.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;
    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody UserInfoVO userInfoVO){
        return ResponseEntity.accepted().body("user created with id : "+service.saveUser(userInfoVO));
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers(){
        return ResponseEntity.ok().body("USERS");
    }
}
