package com.saurabh.example.restful.restfulwebservices.controller;

import com.saurabh.example.restful.restfulwebservices.dto.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//@Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String hellOWorld() {
        return "Hello World";
    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean hellOWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean hellOWorldBeanPathVariable(@PathVariable("name") String name) {
        return new HelloWorldBean("Hello World "+name);
    }

    @GetMapping("/hello-world-interN")
    public String hellOWorldInternationalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);

    }
}
