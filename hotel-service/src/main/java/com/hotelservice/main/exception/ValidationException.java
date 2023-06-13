package com.hotelservice.main.exception;

import com.hotelservice.main.exception.errorVOs.ErrorVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationException extends RuntimeException{
    private List<ErrorVO> errors;
}
