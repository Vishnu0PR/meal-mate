package com.hotelservice.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel/")
public class HotelController {

    @GetMapping("hotel-test")
    public ResponseEntity<String> testPoint(){
        return ResponseEntity.ok().body("TEST_PASSED");
    }

    @GetMapping("global-filter")
    public ResponseEntity<String> filterTestPoint(@RequestHeader Map<String,String> headers){
        return ResponseEntity.ok().body(headers.get("global-filter-key")+" & "+headers.get("pre-filter-key"));
    }
}
