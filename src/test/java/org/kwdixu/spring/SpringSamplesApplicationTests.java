package org.kwdixu.spring;

import org.junit.jupiter.api.Test;
import org.kwdixu.spring.util.CommonEvent;
import org.kwdixu.spring.util.SpringContextUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class SpringSamplesApplicationTests {


    @Test
    void contextLoads() throws InterruptedException {


        CommonEvent commonEvent = new CommonEvent(this);
        commonEvent.setTaskId(String.valueOf(123));

        SpringContextUtil.getApplicationContext().publishEvent(commonEvent);


        Thread.sleep(10 * 1000);
    }

}
