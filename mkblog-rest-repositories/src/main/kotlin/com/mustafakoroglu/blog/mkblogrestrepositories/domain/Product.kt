package com.mustafakoroglu.blog.mkblogrestrepositories.domain

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Entity
data class Product(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val name: String? = null,
        val price: BigDecimal? = null
)