package org.kwdixu.spring;

import org.kwdixu.spring.cmd_router.CmdMappingBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSamplesApplication.class, args);
        CmdMappingBeanPostProcessor.execute("joinRoom", "123");
    }

}
