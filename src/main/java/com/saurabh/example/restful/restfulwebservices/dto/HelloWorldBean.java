package com.saurabh.example.restful.restfulwebservices.dto;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HelloWorldBean {

    private String message;
    public HelloWorldBean(String hello_world) {
    message=hello_world;
    }

}
