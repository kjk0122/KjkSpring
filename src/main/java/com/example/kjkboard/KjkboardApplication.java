package com.example.kjkboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class KjkboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(KjkboardApplication.class, args);
    }

}
