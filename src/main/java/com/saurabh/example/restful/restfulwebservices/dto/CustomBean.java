package com.saurabh.example.restful.restfulwebservices.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@JsonIgnoreProperties(value = {"value1","value2"})//to ignore multiple properties from json response
public class CustomBean {
    private String value1;
    private String value2;

    //@JsonIgnore  //value3 will not be part of json response
    private String value3;
}
