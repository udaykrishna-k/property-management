package com.myfirstcompany.property_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldException(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel em = null;
        List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();
        for(FieldError fe : fieldErrorList){
            em = new ErrorModel();
            em.setMessage(fe.getDefaultMessage());
            em.setCode(fe.getCode());
            errorModelList.add(em);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_GATEWAY);
    }
}
