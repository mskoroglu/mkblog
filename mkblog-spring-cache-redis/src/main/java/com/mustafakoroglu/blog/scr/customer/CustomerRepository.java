package com.mustafakoroglu.blog.scr.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Mustafa Köroğlu
 */
@Repository
public class CustomerRepository {
    private static final AtomicLong idGenerator = new AtomicLong();
    private static final Map<Long, Customer> CUSTOMERS = new HashMap<>();

    List<Customer> getCustomers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(CUSTOMERS.values());
    }

    void save(Customer customer) {
        customer.setId(idGenerator.incrementAndGet());
        CUSTOMERS.put(customer.getId(), customer);
    }
}
