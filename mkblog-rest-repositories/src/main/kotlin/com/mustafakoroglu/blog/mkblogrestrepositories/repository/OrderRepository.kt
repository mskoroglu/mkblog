package com.mustafakoroglu.blog.mkblogrestrepositories.repository

import com.mustafakoroglu.blog.mkblogrestrepositories.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@RepositoryRestResource
interface OrderRepository : JpaRepository<Order, Long>