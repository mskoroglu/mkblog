package com.mustafakoroglu.blog.mkblogspringdata;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private int age;
    private String name;

    Customer() {
        // Bu argümansız constructor, JPA'in kayıttan nesne oluşturabilmesi için şart
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}