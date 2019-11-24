package top.os.fun.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Jacky on 2019-01-05 13:34.
 */
@Service
public class AsynTaskServiceImpl {

    // 异步方法 需要@EnableAsync // 开启异步任务
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是测试...");
    }
}
