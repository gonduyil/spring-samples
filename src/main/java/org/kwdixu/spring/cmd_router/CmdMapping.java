package org.kwdixu.spring.cmd_router;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CmdMapping {

    /**
     * cmd
     */
    String value();
}
