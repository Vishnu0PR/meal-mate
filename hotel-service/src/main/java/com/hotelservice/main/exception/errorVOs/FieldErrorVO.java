package com.hotelservice.main.exception.errorVOs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FieldErrorVO {
    private String fieldName;
    private List<String> message;
}
