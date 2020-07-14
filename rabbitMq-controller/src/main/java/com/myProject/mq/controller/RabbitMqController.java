package com.myProject.mq.controller;

import com.myProject.mq.service.RabbitMqService;
import com.myProject.mq.service.recv.Recv;
import com.myProject.mq.service.send.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Recv recv;

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
        send.send();
    }


}
