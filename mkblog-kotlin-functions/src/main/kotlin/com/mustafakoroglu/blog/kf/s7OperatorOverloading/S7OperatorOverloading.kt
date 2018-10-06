package com.mustafakoroglu.blog.kf.s7OperatorOverloading

import com.mustafakoroglu.blog.kf.HttpBinOrgService
import com.mustafakoroglu.blog.kf.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author Mustafa Köroğlu
 */
fun main(args: Array<String>) {
    val service = retrofit.create<HttpBinOrgService>()
    service.getSlideshow() then { call, throwable, response ->
        if (!response) throw RuntimeException(throwable)

        val slideshowResponse = response?.body()
        println(slideshowResponse)
    }
}

operator fun <T> Response<T>?.not() = this == null || !this.isSuccessful

inline fun <reified T> Retrofit.create(): T = create(T::class.java)

typealias RetrofitCallback<T> = (Call<T>, Throwable?, Response<T>?) -> Unit

infix fun <T> Call<T>.then(cb: RetrofitCallback<T>) = enqueue(object : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) = cb(call, t, null)
    override fun onResponse(call: Call<T>, response: Response<T>) = cb(call, null, response)
})