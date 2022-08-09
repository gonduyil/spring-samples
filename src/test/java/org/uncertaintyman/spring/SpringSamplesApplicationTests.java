package org.uncertaintyman.spring;

import org.junit.jupiter.api.Test;
import org.uncertaintyman.spring.event.CommonEvent;
import org.uncertaintyman.spring.spring_helper.SpringContextUtil;
import org.springframework.boot.test.context.SpringBootTest;

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
