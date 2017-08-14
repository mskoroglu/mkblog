package com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.repository

import com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
interface CustomerRepository : JpaRepository<Customer, Long>