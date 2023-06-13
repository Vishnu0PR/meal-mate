package com.hotelservice.main.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {
    private Long itemId;
    @NotEmpty(message = "item name can not be empty")
    private String itemName;
    @NotEmpty(message = "category can not be empty")
    private String category;
    private String type;
    @NotNull(message = "price is required")
    private BigDecimal price;
    private Boolean isAvail;
}
