package com.javaclass.anatolianweb;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@SpringBootApplication
public class AnatolianWebApplication {

    public AnatolianWebApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(AnatolianWebApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/").allowedOrigins(new String[]{"http://localhost:8080"});
            }
        };
    }



}
