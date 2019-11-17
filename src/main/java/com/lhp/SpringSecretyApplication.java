package com.lhp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SpringSecretyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecretyApplication.class, args);
    }

}
