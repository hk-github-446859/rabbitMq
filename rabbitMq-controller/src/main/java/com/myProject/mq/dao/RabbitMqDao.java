package com.myProject.mq.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RabbitMqDao {
    List<Map<String, Object>> test();
}
