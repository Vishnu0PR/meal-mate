package com.orderservice.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hotel-service", url = "${hotel.config.hotel-url}")
public interface HotelServiceClient {

    @GetMapping("hotel-test")
    String clientTest();
}
