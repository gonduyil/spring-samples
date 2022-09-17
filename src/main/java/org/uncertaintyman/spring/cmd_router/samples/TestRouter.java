package org.uncertaintyman.spring.cmd_router.samples;

import org.uncertaintyman.spring.cmd_router.BizMapping;
import org.uncertaintyman.spring.cmd_router.BizRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@BizRouter
public class TestRouter {

    private static final Logger logger = LoggerFactory.getLogger(TestRouter.class);

    @BizMapping("joinRoom")
    public String getTest(String params) {
        logger.info("getTest|params:{}", params);
        return "getTest123456";
    }

    @BizMapping("onClass")
    public String onClassCmd(String params) {
     //   logger.info("onClassCmd|params:{}", params);
        //System.out.println(1);
        return "getTest123456";
    }


}
