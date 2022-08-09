package org.uncertaintyman.spring.cmd_router;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizMapping {

    /**
     * cmd
     */
    String value();
}
