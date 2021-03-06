package top.os.fun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.os.fun.service.impl.AsynTaskServiceImpl;

/**
 * Created by Jacky on 2019-01-05 13:39.
 */

@RestController
public class AsynTaskController {

    @Autowired
    private AsynTaskServiceImpl service;

    @GetMapping("/hello")
    public String hello() {
        service.hello();
        return "success";
    }

    @GetMapping("/ex")
    public String ex(String a) {
        if (StringUtils.isEmpty(a)) {
            throw new RuntimeException("测试异常");
        }
        return a;
    }
}
