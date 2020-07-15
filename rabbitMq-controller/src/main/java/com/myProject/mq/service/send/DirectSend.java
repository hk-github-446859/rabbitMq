package com.myProject.mq.service.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "direct第一个广播消息";
        System.out.println("direct-message" + msg1);
        rabbitTemplate.convertAndSend("directExchange", "direct.messages", msg1);

    }

}
