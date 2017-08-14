package com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.controller

import com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.domain.Customer
import com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.repository.CustomerRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Controller
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

    @GetMapping
    fun listPage(map: ModelMap): String {
        map.put("customers", customerRepository.findAll())
        return "customer_list"
    }

    @GetMapping("/new")
    fun newCustomerPage(map: ModelMap): String {
        map.put("customer", Customer())
        return "new_customer"
    }

    @PostMapping
    fun addCustomer(@ModelAttribute customer: Customer): String {
        customerRepository.save(customer)
        return "redirect:/customers"
    }

    @GetMapping("/{customer}/delete")
    fun deleteCustomer(@PathVariable customer: Customer): String {
        customerRepository.delete(customer)
        return "redirect:/customers"
    }
}