package com.mustafakoroglu.blog.mkblogspringdata;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    Customer byId(@PathVariable Long id) {
        return customerRepository.findOne(id);
    }

    @PostMapping
    Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{customer}")
    void delete(@PathVariable Customer customer) {
        customerRepository.delete(customer);
    }

    @GetMapping("/search")
    List<Customer> searchByAge(@RequestParam int age) {
        return customerRepository.findByAge(age);
    }
}