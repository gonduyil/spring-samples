package org.kwdixu.spring.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EnvHelper {


    @Value("${spring.profiles.active}")
    private String active;

    public boolean isTestEnv() {
        return Objects.equals(active, "test");
    }

}
