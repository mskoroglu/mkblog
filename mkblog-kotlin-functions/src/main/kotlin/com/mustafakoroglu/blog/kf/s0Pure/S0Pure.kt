package com.mustafakoroglu.blog.kf.s0Pure

import com.mustafakoroglu.blog.kf.HttpBinOrgService
import com.mustafakoroglu.blog.kf.SlideshowResponse
import com.mustafakoroglu.blog.kf.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Mustafa Köroğlu
 */
fun main(args: Array<String>) {
    val service = retrofit.create(HttpBinOrgService::class.java)
    service.getSlideshow().enqueue(object : Callback<SlideshowResponse?> {
        override fun onFailure(call: Call<SlideshowResponse?>, t: Throwable) {
            t.printStackTrace()
        }

        override fun onResponse(call: Call<SlideshowResponse?>, response: Response<SlideshowResponse?>) {
            val slideshowResponse = response.body()
            println(slideshowResponse)
        }
    })
}