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



    private ResultVO(ResultStateEnum resultStateEnum, T t){
        this.code = resultStateEnum.getCode();
        this.message = resultStateEnum.getMessage();
        this.data = t;
    }

    public static <T> ResultVO<T> success(){
        return new ResultVO<>(ResultStateEnum.SUCCESS);
    }


    public static <T> ResultVO<T> success(T t){
        return new ResultVO<>(ResultStateEnum.SUCCESS, t);
    }


    public static <T> ResultVO<T> error(ResultStateEnum resultStateEnum){
        return new ResultVO<>(resultStateEnum);
    }
}
