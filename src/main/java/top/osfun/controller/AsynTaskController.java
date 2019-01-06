package top.osfun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.osfun.task.AsynTaskServiceImpl;

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
}
