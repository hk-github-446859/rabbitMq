package com.myProject.mq.service.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "第一个广播消息";
        System.out.println("sender-message" + msg1);
        rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "第二个广播消息";
        System.out.println("sender-messages" + msg2);
        rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}
