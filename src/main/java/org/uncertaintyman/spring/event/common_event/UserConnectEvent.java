package org.uncertaintyman.spring.event.common_event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserConnectEvent {
    
    private Long userId;

    private String username;
}
