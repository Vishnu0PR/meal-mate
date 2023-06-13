package com.hotelservice.main.entity;

import com.hotelservice.main.enums.Category;
import com.hotelservice.main.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hotel_menu")
public class HotelMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long itemId;
    private String itemName;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;
    private BigDecimal price;
    private Boolean isAvail;
}
