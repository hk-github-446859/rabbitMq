package com.myProject.mq.controller;

import com.myProject.mq.service.RabbitMqService;
import com.myProject.mq.service.recv.Recv;
import com.myProject.mq.service.send.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mq")
public class RabbitMqController {
    @Autowired
    private RabbitMqService mqService;

    @Autowired
    private Send send;

    @Autowired
    private Send2 send2;

    @Autowired
    private UserSend userSend;

    @Autowired
    private TopicSend topicSend;


    @Autowired
    private DirectSend directSend;


    @GetMapping("/test")
    public List<Map<String, Object>> test() {

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("hello", "word");
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        list.add(map);
//        return list;
        List<Map<String, Object>> test = mqService.test();
        return test;
    }


    @GetMapping("/hello")
    public void hello() {
        send.send("单个消息" );
    }

    @GetMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            send.send("多个消息"+i);
        }

    }

    /**
     * 多生产者-多消费者
     */
    @GetMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            send.send("hellomsg:"+i);
            send2.send("hellomsg:"+i);
        }

    }

    @GetMapping("/user")
    public void user() {
        userSend.send();
    }

    @GetMapping("/topicSend")
    public void topicSend() {
        topicSend.send();
    }

    @GetMapping("/directSend")
    public void directSend() {
        directSend.send();
    }
}
