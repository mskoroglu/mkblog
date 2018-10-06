package com.mustafakoroglu.blog.kf

import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET

/**
 * @author Mustafa Köroğlu
 */
val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://httpbin.org")
        .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().findAndRegisterModules()))
        .build()

interface HttpBinOrgService {
    @GET("/json")
    fun getSlideshow(): Call<SlideshowResponse>
}

data class Slide(val title: String?, val type: String?, val items: List<String>?)

data class Slideshow(val author: String?, val date: String?, val title: String?, val slides: List<Slide>?)

data class SlideshowResponse(val slideshow: Slideshow?) {
    override fun toString(): String {
        val (author, date, title, slides) = slideshow!!
        val slideTitles = slides!!.asSequence().map { it.title }.joinToString()
        return """
            author: $author
            date: $date
            title: $title
            slides: [ $slideTitles ]"""
    }
}