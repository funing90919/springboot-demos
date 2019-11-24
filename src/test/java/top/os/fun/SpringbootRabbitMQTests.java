package top.os.fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.os.fun.domain.UserVO;

/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.连接工厂CachingConnectionFactory
 * 3.RabbitTemplate，发送和接收消息
 * 4.AmqpAdmin，系统管理组件:创建和删除Queue，Exchange，Binding
 * 5.@EnableRabbit + @RabbitListener监听队列
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitMQTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    private static final String EXCHANGE_DIRECT = "exchange.direct";
    private static final String EXCHANGE_FANOUT = "exchange.fanout";
    private static final String EXCHANGE_TOPIC = "exchange.topic";
    private static final String EXCHANGE_DIRECT_USER = "user";
    private static final String EXCHANGE_DIRECT_USER_NEWS = "user.news";
    private static final String EXCHANGE_DIRECT_USER_FOOD = "user.food";
    private static final String EXCHANGE_DIRECT_DOG_NEWS = "dog.news";
    private static final String EXCHANGE_DIRECT_DOG_FOOD = "dog.food";
    private static final String QUEUE_USER = "user";

    /**
     * 1.direct
     */
    @Test
    public void test1() {
        // 1.rabbitTemplate.send(exchange, routkey, message);
        // 2.rabbitTemplate.convertAndSend(exchange, routkey, object);自动序列化
        UserVO userVO = new UserVO();
        userVO.setId(11);
        userVO.setUserName("hahhaha");
        userVO.setAge(20);
        // 传入发送对象，自动序列化并发送给rabbitmq
        rabbitTemplate.convertAndSend(EXCHANGE_DIRECT, EXCHANGE_DIRECT_USER, userVO);
    }

    /**
     * 接收消息
     */
    @Test
    public void test2() {
        // 默认存储JDK序列化后的值，修改为JSon可修改默认MessageConverter配置为Jackson2JsonMessageConverter
        // @see MyAMQPConfig
        Object o = rabbitTemplate.receiveAndConvert(QUEUE_USER);
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 2.fanout
     */
    @Test
    public void test3() {
        UserVO userVO = new UserVO();
        userVO.setId(12);
        userVO.setUserName("hehheeheh");
        userVO.setAge(21);
        // 广播不需要路由键
        rabbitTemplate.convertAndSend(EXCHANGE_FANOUT, "", userVO);
    }

    // 创建和删除Queue，Exchange，Binding
    @Test
    public void test4() {
        amqpAdmin.declareExchange(new DirectExchange("system.create.exchange"));
        amqpAdmin.declareQueue(new Queue("system.create.queue", true));
        amqpAdmin.declareBinding(new Binding("system.create.queue",
                Binding.DestinationType.QUEUE,
                "system.create.exchange",
                "system.create",
                null));
    }

}

