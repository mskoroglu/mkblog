package com.mustafakoroglu.blog.scr.customer;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mustafa Köroğlu
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Cacheable("customersCache")
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @CacheEvict(value = "customersCache", allEntries = true)
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
