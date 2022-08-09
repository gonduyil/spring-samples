package org.uncertaintyman.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertiesTests {

    @Value("${spring.profiles.active}")
    private String active;

    @Test
    void test() {
        System.out.println(active);
    }
}
