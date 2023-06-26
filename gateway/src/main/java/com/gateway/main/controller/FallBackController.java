package com.gateway.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FallBackController {

    @GetMapping("/fall-back")
    public ResponseEntity<String> fallBack(){
        return ResponseEntity.internalServerError().body("We are facing some issue.Please contact help desk");
    }
}
