package com.hotelservice.main.exception.errorVOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorVO {
    private Object errorCode;
    private String errorMessage;
}
