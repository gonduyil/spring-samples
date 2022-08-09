package org.uncertaintyman.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListeners {

    @EventListener
    public void onEvent(CommonEvent event) {
        System.out.println("event:" + event.getTaskId());
    }
}
