package com.mustafakoroglu.blog.kf.s1HigherOrder

import com.mustafakoroglu.blog.kf.HttpBinOrgService
import com.mustafakoroglu.blog.kf.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Mustafa Köroğlu
 */
fun main(args: Array<String>) {
    val service = retrofit.create(HttpBinOrgService::class.java)
    service.getSlideshow().enqueue(callback { call, throwable, response ->
        response ?: throw RuntimeException(throwable)

        val slideshowResponse = response.body()
        println(slideshowResponse)
    })
}

fun <T> callback(cb: (call: Call<T>, throwable: Throwable?, response: Response<T>?) -> Unit) = object : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) = cb(call, t, null)
    override fun onResponse(call: Call<T>, response: Response<T>) = cb(call, null, response)
}