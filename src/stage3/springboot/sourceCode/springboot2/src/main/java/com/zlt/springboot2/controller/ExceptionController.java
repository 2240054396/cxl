package com.zlt.springboot2.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler({NullPointerException.class})
//    public String nullPointer(){
//        log.info("nullPointerException");
//        return  "err";
//    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<?> nullPointer(){
        log.info("nullPointerException");
        return new ResponseEntity<>("nullPointerException2", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
