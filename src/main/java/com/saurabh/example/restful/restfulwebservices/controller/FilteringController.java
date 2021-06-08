package com.saurabh.example.restful.restfulwebservices.controller;

import com.saurabh.example.restful.restfulwebservices.dto.CustomBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filteredBean")
    public CustomBean filteredBean(){
        return new CustomBean("Value1","Value2","Value3");
    }

    @GetMapping("/filteredBean-list")
    public List<CustomBean> filteredBeanList(){
        return Arrays.asList(new CustomBean("Value11","Value12","Value13"),
                new CustomBean("Value1","Value2","Value3"));
    }
}
