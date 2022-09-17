package org.uncertaintyman.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uncertaintyman.spring.cmd_router.BizMappingBeanPostProcessor;
import org.uncertaintyman.spring.cmd_router.samples.TestRouter;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestRouter testRouter;

    @GetMapping("/run")
    public String run() {
        StopWatch watch = new StopWatch();
        watch.start();
        /**
         执行1亿次  无println, cost: 9358毫秒
         执行1亿次  有println, cost:

         */
        for (int i =1; i <= 100_000_000; i++) {

            testRouter.onClassCmd("");
        }
        watch.stop();
        logger.info("run| cost:{}", watch.getTotalTimeMillis());
        return "";
    }


    /*
    cost:72
     */
    @GetMapping("/run2")
    public String run2() {
        StopWatch watch = new StopWatch();
        watch.start();

        for (int i =1; i <= 100_000_000; i++) {
            BizMappingBeanPostProcessor.execute("onClass", "");
        }
        watch.stop();
        logger.info("run2| cost:{}", watch.getTotalTimeMillis());
        return "";
    }
}
