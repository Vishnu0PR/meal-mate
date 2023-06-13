package com.hotelservice.main.exception;

import com.hotelservice.main.exception.errorVOs.ErrorVO;
import com.hotelservice.main.exception.errorVOs.FieldErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<ErrorVO>> validationExceptionHandler(ValidationException ex){
        return ResponseEntity.badRequest().body(ex.getErrors());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorVO>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        List<FieldErrorVO> errors = ex.getBindingResult().getAllErrors().stream().map(objectError ->
                        FieldErrorVO.builder()
                                .fieldName(((FieldError) objectError).getField())
                                .message(List.of(Objects.requireNonNull(objectError.getDefaultMessage())))
                                .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
