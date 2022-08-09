package org.uncertaintyman.spring;

import org.uncertaintyman.spring.cmd_router.CmdMappingBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSamplesApplication.class, args);
        CmdMappingBeanPostProcessor.execute("joinRoom", "123");
    }

}
