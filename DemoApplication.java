package com.proyectobbackenduniremington2026.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Esto le dice a Spring que busque en todas tus carpetas
@ComponentScan(basePackages = "com.proyectobbackenduniremington2026")
@EntityScan(basePackages = "com.proyectobbackenduniremington2026.model")
@EnableJpaRepositories(basePackages = "com.proyectobbackenduniremington2026.repository")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}