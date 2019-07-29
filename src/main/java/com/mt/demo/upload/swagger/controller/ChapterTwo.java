package com.mt.demo.upload.swagger.controller;

import com.mt.demo.upload.swagger.config.ResultVO;
import com.mt.demo.upload.swagger.dto.OneDTO;
import com.mt.demo.upload.swagger.dto.TwoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ChapterTwo
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/two")
@Api("ChapterTwo")
public class ChapterTwo {

    @ApiOperation(value = "two", notes = "two", httpMethod = "POST")
    @PostMapping("/post")
    public ResultVO post(@Valid @RequestBody OneDTO oneDTO){
        return ResultVO.success(oneDTO);
    }

    @ApiOperation(value = "two", notes = "two", httpMethod = "POST")
    @PostMapping("/post1")
    public ResultVO post(@Valid @RequestBody TwoDTO oneDTO){
        return ResultVO.success(oneDTO);
    }
}
