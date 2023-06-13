package com.hotelservice.main.service.impl;

import com.hotelservice.main.entity.HotelMenu;
import com.hotelservice.main.enums.Category;
import com.hotelservice.main.exception.ValidationException;
import com.hotelservice.main.exception.errorVOs.ErrorVO;
import com.hotelservice.main.repository.HotelMenuRepository;
import com.hotelservice.main.service.MenuService;
import com.hotelservice.main.vo.MenuVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final HotelMenuRepository repository;
    private final ModelMapper mapper;

    @Override
    public Long addItem(MenuVO menuVO) {
        validateNewItemRequest(menuVO);
        menuVO.setIsAvail(true);
        return repository.save(mapper.map(menuVO,
                HotelMenu.class)).getItemId();
    }

    @Override
    public List<MenuVO> showMenu() {
        return repository.findAll().stream()
                .map(item -> mapper.map(item, MenuVO.class))
                .collect(Collectors.toList());
    }

    private void validateNewItemRequest(MenuVO menuVO) {
        List<ErrorVO> errors = new ArrayList<>();
        if (repository.existsByItemName(menuVO.getItemName())) {
            errors.add(new ErrorVO("ITEM_EXISTS",
                    "ITEM WITH SAME NAME EXISTS"));
        }
        try {
            Category category = Category.valueOf(menuVO.getCategory().toUpperCase());
            menuVO.setCategory(category.name());
        } catch (Exception e) {
            errors.add(new ErrorVO("INVALID_CATEGORY",
                    "PLEASE ENTER A VALID CATEGORY"));
        }
        if (!CollectionUtils.isEmpty(errors)) {
            throw new ValidationException(errors);
        }
    }
}
