package com.mustafakoroglu.blog.mkblogspringdata;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAge(int age);
}