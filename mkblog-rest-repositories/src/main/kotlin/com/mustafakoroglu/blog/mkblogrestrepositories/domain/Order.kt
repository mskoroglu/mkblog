package com.mustafakoroglu.blog.mkblogrestrepositories.domain

import javax.persistence.*

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Entity
@Table(name = "\"order\"")
data class Order(
        @Id
        @GeneratedValue
        val id: Long? = null,

        @ManyToMany
        val products: List<Product>? = null
) {
    fun getOrderAmount() = products!!.map { it.price }.reduce { a, b -> a!!.add(b) }
}