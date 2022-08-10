package com.teispace.simpleblog.exceptions;

import com.teispace.simpleblog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleRNF(ResourceNotFoundException ex){
        //ApiResponse apiResponse = new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        Map <String,Object> response  = new HashMap<>();
        response.put("message",ex.getMessage());
        response.put("timestamp",ZonedDateTime.now());
        response.put("status",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleE(Exception ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now());
        return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}

