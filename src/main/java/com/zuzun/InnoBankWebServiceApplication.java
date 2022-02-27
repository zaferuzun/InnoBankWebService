package com.zuzun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class InnoBankWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnoBankWebServiceApplication.class, args);
    }

}
