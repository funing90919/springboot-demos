package top.osfun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.osfun.service.MyOrderService;

/**
 * @Description
 * @Auth 01381782 Funing
 * @Date 2019-04-03 10:30
 */
@RestController
public class AsynSercieController {

    @Autowired
    private MyOrderService myOrderService;

    @RequestMapping("/add")
    public void addEmployee() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> myOrderService.updateMyOrder()).start();
        }
    }
}
