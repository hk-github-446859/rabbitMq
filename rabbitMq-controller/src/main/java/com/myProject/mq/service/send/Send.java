package com.myProject.mq.service.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Send {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String s) {
        String sendMsg = s + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}
