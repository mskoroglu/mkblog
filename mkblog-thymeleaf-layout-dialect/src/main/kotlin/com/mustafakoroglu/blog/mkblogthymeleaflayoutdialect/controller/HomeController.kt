package com.mustafakoroglu.blog.mkblogthymeleaflayoutdialect.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Controller
class HomeController {

    @GetMapping("/")
    fun homePage() = "redirect:/customers"
}