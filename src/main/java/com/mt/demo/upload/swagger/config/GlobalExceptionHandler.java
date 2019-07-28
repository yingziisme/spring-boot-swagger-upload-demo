package com.mt.demo.upload.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultVO<Void> exceptionHandler(Exception e) {
        log.info("go to global exception handler: {}", e);
        return ResultVO.error(ResultStateEnum.ERROR);

    }
}
