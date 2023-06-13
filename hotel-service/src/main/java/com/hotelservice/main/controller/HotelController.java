package com.hotelservice.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel/")
public class HotelController {

    @GetMapping("hotel-test")
    public ResponseEntity<String> testPoint(){
        return ResponseEntity.ok().body("TEST_PASSED");
    }
}
