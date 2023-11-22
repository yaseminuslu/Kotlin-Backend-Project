package com.kotlinbackendproject;

import com.kotlinbackendproject.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.kotlinbackendproject")
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
@EntityScan(basePackages = "com.kotlinbackendproject.entity")
public class KotlinBackendProjectApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(KotlinBackendProjectApplication.class, args);
    }

}
