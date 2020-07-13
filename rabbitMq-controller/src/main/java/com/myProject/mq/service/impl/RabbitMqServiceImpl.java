package com.myProject.mq.service.impl;

import com.myProject.mq.dao.RabbitMqDao;
import com.myProject.mq.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private RabbitMqDao rabbitMqDao;

    public List<Map<String, Object>> test() {
        return rabbitMqDao.test();
    }
}

