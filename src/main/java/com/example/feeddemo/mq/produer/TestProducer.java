package com.example.feeddemo.mq.produer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiedong
 * Date: 2022/7/22
 */
@Configuration
@Slf4j
public class TestProducer {
    private String testTopid = "test-a-testBasic-topic";
    private String testProducer = "test-a-testBasic-topic-producer";

//    @Bean(initMethod = "start", destroyMethod = "shutdown", name = "testAProducer")
//    public RocketMQProducer testAProducer() {
//        RocketMQProducer rocketMQProducer = new RocketMQProducer(testProducer, testTopid);
////        rocketMQProducer.setMqCloudDomain("192.168.50.10:8080");
//        return rocketMQProducer;
//    }
}
