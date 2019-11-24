package top.os;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync // 开启异步任务
@EnableScheduling // 开启定时任务
@EnableRabbit // @EnableRabbit + @RabbitListener监听队列
@SpringBootApplication
public class SpringbootDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemosApplication.class, args);
    }

}

