package com.mt.demo.upload.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * OneDTO
 *
 * @author mt.luo
 * @description:
 */
@Data
@ApiModel("One")
public class OneDTO {
    private String user;
    private String password;
}
