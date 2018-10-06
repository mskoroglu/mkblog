package com.mustafakoroglu.blog.kf.s8DelegatedProperties

import com.mustafakoroglu.blog.kf.HttpBinOrgService
import com.mustafakoroglu.blog.kf.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.reflect.KProperty

/**
 * @author Mustafa Köroğlu
 */
fun main(args: Array<String>) {
    val service: HttpBinOrgService by retrofit
    service.getSlideshow() then { call, throwable, response ->
        response ?: throw RuntimeException(throwable)

        val slideshowResponse = response.body()
        println(slideshowResponse)
    }
}

operator fun <T> Retrofit.getValue(nothing: Nothing?, property: KProperty<*>) =
        create(Class.forName((property.returnType as Any).toString())) as T

typealias RetrofitCallback<T> = (Call<T>, Throwable?, Response<T>?) -> Unit

infix fun <T> Call<T>.then(cb: RetrofitCallback<T>) = enqueue(object : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) = cb(call, t, null)
    override fun onResponse(call: Call<T>, response: Response<T>) = cb(call, null, response)
})