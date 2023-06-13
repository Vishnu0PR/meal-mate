package com.orderservice.main.controller;

import com.orderservice.main.client.HotelServiceClient;
import com.orderservice.main.client.MenuServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order/")
public class OrderController {

    private final HotelServiceClient hotelServiceClient;
    private final MenuServiceClient menuServiceClient;

    @GetMapping("order-test")
    public ResponseEntity<String> testMethod() {
        return ResponseEntity.ok().body("ORDER_SERVICE_TEST " +
                hotelServiceClient.clientTest()+" "+menuServiceClient.menuClientCall());
    }
}
