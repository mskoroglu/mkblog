package com.mustafakoroglu.blog.scr.rest;

import com.mustafakoroglu.blog.scr.customer.Customer;
import com.mustafakoroglu.blog.scr.customer.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mustafa Köroğlu
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    void saveCustomer(Customer customer) {
        customerService.save(customer);
    }
}