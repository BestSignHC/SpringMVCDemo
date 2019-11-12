package com.hecheng.demo.service;

import com.alibaba.fastjson.JSON;
import com.hecheng.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String finaAll() {
        List<Demo> all = mongoTemplate.findAll(Demo.class);

        return JSON.toJSONString(all);
    }

    public Demo findOne(String key, Object value) {
        Query query = new Query(Criteria.where(key).is(value));
        Demo queryDemo = mongoTemplate.findOne(query, Demo.class);
        return queryDemo;
    }

    public void add(Demo demo) {
        mongoTemplate.insert(demo, "demo");
    }
}
