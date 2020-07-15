package com.myProject.mq.service.send;

import com.myProject.mq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user = new User();
        user.setName("消息人");
        user.setPass("123456");
        System.out.println("user send : " + user.getName() + "/" + user.getPass());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }

}
