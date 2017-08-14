package com.mustafakoroglu.blog.mkblogrestrepositories

import com.mustafakoroglu.blog.mkblogrestrepositories.domain.Order
import com.mustafakoroglu.blog.mkblogrestrepositories.domain.Product
import com.mustafakoroglu.blog.mkblogrestrepositories.repository.OrderRepository
import com.mustafakoroglu.blog.mkblogrestrepositories.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Component
import java.math.BigDecimal

@SpringBootApplication
class MkblogRestRepositoriesApplication

fun main(args: Array<String>) {
    SpringApplication.run(MkblogRestRepositoriesApplication::class.java, *args)
}

@Component
class DatabasePopulator(val productRepository: ProductRepository, val orderRepository: OrderRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val product1 = Product(name = "Elbise", price = BigDecimal("64.50"))
        val product2 = Product(name = "Ayakkabı", price = BigDecimal("79.90"))
        val product3 = Product(name = "Çanta", price = BigDecimal("109.90"))
        productRepository.save(listOf(product1, product2, product3))

        orderRepository.save(listOf(
                Order(products = listOf(product1, product3)),
                Order(products = listOf(product2, product2, product2, product3))
        ))
    }
}