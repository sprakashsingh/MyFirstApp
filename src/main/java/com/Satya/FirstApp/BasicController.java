package com.Satya.FirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class BasicController {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BasicController.class, args);
    }
}
