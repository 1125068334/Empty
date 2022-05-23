package com.fujl.spring.other;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(21)
@Component
public class CommandLineRunnerTest2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.toString(args));
        System.out.println("CommandLineRunnerTest222");
    }
}
