package com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Entity
data class Customer(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var name: String? = null,
        var email: String? = null
)