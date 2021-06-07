package com.saurabh.example.restful.restfulwebservices.controller;

import com.saurabh.example.restful.restfulwebservices.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldController {

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
}
