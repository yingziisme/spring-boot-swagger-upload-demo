package com.mt.demo.upload.swagger.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ResultStateEnum
 *
 * @author mt.luo
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum  ResultStateEnum {
    /**
     * success
     */
    SUCCESS(1000, "success"),
    /**
     * error
     */
    ERROR(1001, "error");

    @Getter
    private Integer code;
    @Getter
    private String message;
}
