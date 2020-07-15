package com.myProject.mq.service.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CallBackSend implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String s) {
        rabbitTemplate.setConfirmCallback(this);
        String msg = "this is callback message" + s;
        System.out.println(msg);
        String key = UUID.randomUUID().toString();
        CorrelationData date = new CorrelationData(key);
        System.out.println("key:" + key + "           " + "date.getid" + date.getId());
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg, date);


    }

    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(correlationData.getId() + ":" + b + ":" + s);
    }
}
