package com.myProject.mq.service.recv;

import com.myProject.mq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "userQueue")
public class UserRecv {

    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName() + "/" + user.getPass());
    }
}