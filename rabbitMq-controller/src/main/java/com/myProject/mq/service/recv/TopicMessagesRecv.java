package com.myProject.mq.service.recv;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesRecv {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("topic.messages  : " + hello);
    }
}