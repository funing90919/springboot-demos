package top.osfun.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 两种异常处理方式
 *
 * Created by Jacky on 2019-01-12 20:25.
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 返回json错误信息
    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0011123);
        map.put("message", e.getMessage());
        return map;
    }*/

    // 根据调用客户端的不同，返回不同的信息
    // web返回页面，接口测试工具返回json
    @ExceptionHandler(Exception.class)
    public String handler(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 10001400);
        map.put("message", e.getMessage());
        request.setAttribute("extendError", map);
        // 转发到/error,由BasicErrorController
        return "forward:/error";
    }

}

