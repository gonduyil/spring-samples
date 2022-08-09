package org.uncertaintyman.spring.cmd_router.samples;

import org.uncertaintyman.spring.cmd_router.CmdMapping;
import org.uncertaintyman.spring.cmd_router.CmdRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CmdRouter
public class TestRouter {

    private static final Logger logger = LoggerFactory.getLogger(TestRouter.class);

    @CmdMapping("joinRoom")
    public String getTest(String params) {
        logger.info("getTest|params:{}", params);
        return "getTest123456";
    }


}
