package com.orderservice.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "menu-service", url = "${menu.config.menu-url}")
public interface MenuServiceClient {
    @GetMapping("menu-test")
    String menuClientCall();
}
