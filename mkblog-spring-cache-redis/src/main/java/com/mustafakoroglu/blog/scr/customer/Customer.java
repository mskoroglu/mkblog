package com.mustafakoroglu.blog.scr.customer;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mustafa Köroğlu
 */
@Data
public class Customer implements Serializable {
    private Long id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }
}