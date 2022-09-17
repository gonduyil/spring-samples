package org.uncertaintyman.spring.event.handle;

import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.uncertaintyman.spring.event.common_event.UserConnectEvent;

@Component
public class EventHandle {

    private static final Logger logger = LoggerFactory.getLogger(EventHandle.class);


    @EventListener
    @Async
    public void onUserConnect(UserConnectEvent userConnectEvent) {

        logger.info("event: {}" ,JSON.toJSONString(userConnectEvent));
    }
}
