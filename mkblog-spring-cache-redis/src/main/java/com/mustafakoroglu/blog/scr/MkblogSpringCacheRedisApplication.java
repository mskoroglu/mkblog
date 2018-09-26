package com.mustafakoroglu.blog.scr;

import com.mustafakoroglu.blog.scr.customer.Customer;
import com.mustafakoroglu.blog.scr.customer.CustomerService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class MkblogSpringCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MkblogSpringCacheRedisApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(CustomerService customerService) {
        return args -> {
            customerService.save(new Customer("Mustafa"));
            customerService.save(new Customer("Pelin"));
            customerService.save(new Customer("Kayra"));
        };
    }
}