package org.uncertaintyman.spring;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class IntegerTests {

    @Test
    public void test() {
        int a = 200;
        Integer c = 200;
        Integer b = 200;


        System.out.println(b == c);
        System.out.println(a == b);



        Long x  = 1L;
        long y = 1L;
        System.out.println(Objects.equals(x, y));

    }
}
