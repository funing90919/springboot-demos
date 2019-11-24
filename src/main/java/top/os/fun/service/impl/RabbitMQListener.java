package top.os.fun.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import top.os.fun.domain.UserVO;

/**
 * Created by Jacky on 2019-05-31 13:06.
 */
@Service
public class RabbitMQListener {

    // 需要开启基于注解的模式 @EnableRabbit
    @RabbitListener(queues = {"user"})
    public void receive(UserVO user) {
        System.out.println("收到消息" + user);
    }

    @RabbitListener(queues = {"user.food"})
    public void receive1(Message messgae) {
        System.out.println("收到消息=====");
        System.out.println(messgae.getMessageProperties());
        System.out.println(messgae.getBody());
    }
}
