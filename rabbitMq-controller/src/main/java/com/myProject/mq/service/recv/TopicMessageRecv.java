package com.myProject.mq.service.recv;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageRecv {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("topic.message  : " + hello);
    }
}