package com.ldh.generateid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenerateIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateIdApplication.class, args);

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("系统关闭");
            System.out.println("hhhh");
        }));
    }
}
