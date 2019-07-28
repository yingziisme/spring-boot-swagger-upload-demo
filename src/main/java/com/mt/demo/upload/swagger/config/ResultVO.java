package com.mt.demo.upload.swagger.config;

import lombok.Data;

/**
 * ResultVO
 *
 * @author mt.luo
 * @description:
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String message;
    private T data;

    private ResultVO(ResultStateEnum resultStateEnum){
        this.code = resultStateEnum.getCode();
        this.message = resultStateEnum.getMessage();
    }

    public static <T> ResultVO<T> success(){
        return new ResultVO<>(ResultStateEnum.SUCCESS);
    }

    public static <T> ResultVO<T> error(ResultStateEnum resultStateEnum){
        return new ResultVO<>(resultStateEnum);
    }
}
