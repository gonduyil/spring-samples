package org.kwdixu.spring.event;

import org.springframework.context.ApplicationEvent;

public class CommonEvent extends ApplicationEvent {

    private String taskId;

    public CommonEvent(Object source) {
        super(source);
    }


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
