package com.hotelservice.main.controller;

import com.hotelservice.main.service.MenuService;
import com.hotelservice.main.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu/")
public class MenuController {

    private final MenuService service;

    @GetMapping("menu-test")
    public ResponseEntity<String> menuTest() {
        return ResponseEntity.ok().body("MENU_CONTROLLER");
    }

    @PostMapping("add-item")
    public ResponseEntity<Object> addNewItem(@RequestBody @Valid MenuVO request) {
        return ResponseEntity.accepted().body("ITEM_ADDED_WITH_ID : " + service.addItem(request));
    }

    @GetMapping("show-menu")
    public ResponseEntity<List<MenuVO>> showMenu() {
        return ResponseEntity.ok().body(service.showMenu());
    }
}
