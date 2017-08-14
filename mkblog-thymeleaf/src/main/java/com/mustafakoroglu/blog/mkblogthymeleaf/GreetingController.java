package com.mustafakoroglu.blog.mkblogthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mustafa Köroğlu <mustafa@koroglu.email>
 */
@Controller
public class GreetingController {

    @GetMapping("/")
    String greetingPage(ModelMap map, @RequestParam(required = false) String name) {
        name = name == null || name.trim().equals("") ? "Thymeleaf" : name;
        String message = String.format("Merhaba %s!", name);
        map.put("message", message);
        return "index";
    }
}
