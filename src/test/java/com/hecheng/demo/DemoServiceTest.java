package com.hecheng.demo;

import com.alibaba.fastjson.JSON;
import com.hecheng.demo.entity.Demo;
import com.hecheng.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:conf/applicationContext.xml")
public class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void finaAll() {
        String s = demoService.finaAll();
        System.out.printf(s);
    }

    @Test
    public void add() {
        Demo demo = new Demo();
        Long demoId = new Random().nextLong();
        String demoName = UUID.randomUUID().toString();
        demo.setDemoId(demoId);
        demo.setDemoName(demoName);

        System.out.printf("new demo：" + JSON.toJSONString(demo));

        demoService.add(demo);

        Demo queryDemo = demoService.findOne("demoId", demoId);
        assert queryDemo != null && queryDemo.getDemoName().equals(demoName);
    }
}