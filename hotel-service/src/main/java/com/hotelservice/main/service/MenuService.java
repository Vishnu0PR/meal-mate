package com.hotelservice.main.service;

import com.hotelservice.main.vo.MenuVO;

import java.util.List;

public interface MenuService {
    Long addItem(MenuVO menuVO);
    List<MenuVO> showMenu();
}
