package org.uncertaintyman.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.uncertaintyman.spring.event.CommonEvent;
import org.uncertaintyman.spring.event.common_event.UserConnectEvent;
import org.uncertaintyman.spring.spring_helper.SpringContextUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringSamplesApplicationTests {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    void springCommonEventTest() throws InterruptedException {

        UserConnectEvent event = UserConnectEvent.builder()
                .userId(123L)
                .username("xxxxx")
                .build();
        applicationEventPublisher.publishEvent(event);

        TimeUnit.SECONDS.sleep(5);
    }


    @Test
    void contextLoads() throws InterruptedException {


        CommonEvent commonEvent = new CommonEvent(this);
        commonEvent.setTaskId(String.valueOf(123));

        SpringContextUtil.getApplicationContext().publishEvent(commonEvent);


        Thread.sleep(10 * 1000);
    }

}
