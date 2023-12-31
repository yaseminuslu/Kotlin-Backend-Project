package com.kotlinbackendproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.kotlinbackendproject")
@EnableJpaRepositories(basePackages = "com.kotlinbackendproject")
@EntityScan(basePackages = "com.kotlinbackendproject")
public class KotlinBackendProjectApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(KotlinBackendProjectApplication.class, args);
    }

}
