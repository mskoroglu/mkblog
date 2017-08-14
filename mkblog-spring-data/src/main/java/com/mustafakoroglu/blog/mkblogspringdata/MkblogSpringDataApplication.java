package com.mustafakoroglu.blog.mkblogspringdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MkblogSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MkblogSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner databasePopulator(CustomerRepository repository) {
        return args -> {
            repository.save(new Customer("Mustafa", 30));
            repository.save(new Customer("Kayra", 25));
            repository.save(new Customer("Pelin", 30));
        };
    }
}