//package com.mt.demo.upload.swagger.config;
//
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * FileUploadInterceptor
// *
// * @author mt.luo
// * @description:
// */
////@Component
//public class FileUploadInterceptor implements HandlerInterceptor {
//    private final long MAX_FILE_SIZE = 30 * 1024 * 1024;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if (null != request && ServletFileUpload.isMultipartContent(request)) {
//            long requestSize = new ServletRequestContext(request).contentLength();
//            if (requestSize > MAX_FILE_SIZE) {
//                throw new MaxUploadSizeExceededException(MAX_FILE_SIZE);
//            }
//        }
//        return true;
//    }
//}
