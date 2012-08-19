package com.cyonide.booksniffer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    
    @RequestMapping("/hello")
    public ModelAndView sayHello(){
        
        String greetings = "Just welcome page";
        return new ModelAndView("hello", "greetings", greetings);
    }

}
