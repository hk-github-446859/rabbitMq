package com.myProject.mq.controller;

import com.myProject.mq.service.RabbitMqService;
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

    @GetMapping("/test")
    public List<Map<String, Object>> test() {
        return mqService.test();
//        return "hello word";
    }

}
