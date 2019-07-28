package com.mt.demo.upload.swagger.controller;

import com.mt.demo.upload.swagger.config.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * DemoController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/demo")
@Api("upload")
public class DemoController {

    private final String FILE_SAVE_PATH = "C:";


    private void saveFile(String savePath, String fileFullName, MultipartFile file) throws Exception {

        log.info("file:{}, size:{}", fileFullName, file.getSize());
        byte[] data = readInputStream(file.getInputStream());

        // 判断文件夹是否存在，不存在就创建一个

        File fileDirectory = new File(savePath);
        log.info("uploadDirectory: {}", fileDirectory.getAbsolutePath());

        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdirs()) {
                throw new Exception("文件夹创建失败！路径为：" + savePath);
            }
        }
        // new一个文件对象用来保存，默认保存当前工程根目录
        File uploadFile = new File(savePath + fileFullName);
        log.info("uploadDirectory: {}", uploadFile.getAbsolutePath());

        // 创建输出流
        // 写入数据
        try (FileOutputStream outStream = new FileOutputStream(uploadFile)) {

            outStream.write(data);
            outStream.flush();

        } catch (Exception e) {
            log.error("error:{}", e);
            throw e;
        }
    }

    private byte[] readInputStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串

        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕

        int len;
        // 使用一个输入流从buffer里把数据读取出来

        while ((len = inStream.read(buffer)) != -1) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度

            outStream.write(buffer, 0, len);
        }
        // 关闭输入流

        inStream.close();
        // 把outStream里的数据写入内存

        return outStream.toByteArray();
    }

    @PostMapping
    @ApiOperation(value = "/upload", notes = "upload", httpMethod = "POST")
    public ResultVO<Void> upload(@RequestPart(name = "file") MultipartFile file) throws Exception {
        saveFile(FILE_SAVE_PATH, file.getOriginalFilename(), file);
        return ResultVO.success();
    }
}
