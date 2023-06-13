package com.hotelservice.main.repository;

import com.hotelservice.main.entity.HotelMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelMenuRepository extends JpaRepository<HotelMenu, Long> {
    boolean existsByItemName(String itemName);
}