package com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect

import com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.domain.Customer
import com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.repository.CustomerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MkblogThymeleafLayoutDialectApplication {

    @Bean
    fun databasePopulator(customerRepository: CustomerRepository) = CommandLineRunner {
        customerRepository.save(listOf(
                Customer(name = "Leyla", email = "l@g.com"),
                Customer(name = "Mustafa", email = "m@k.com"),
                Customer(name = "Pelin", email = "p@a.com")
        ))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(MkblogThymeleafLayoutDialectApplication::class.java, *args)
}