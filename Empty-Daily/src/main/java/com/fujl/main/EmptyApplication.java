package com.fujl.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.fujl.*"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EmptyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyApplication.class, args);
    }
}
