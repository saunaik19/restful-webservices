package com.saurabh.example.restful.restfulwebservices.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.saurabh.example.restful.restfulwebservices.dto.CustomBean;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filteredBean")
    public MappingJacksonValue filteredBean() {

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("CustomBeanFilter", filter);

        MappingJacksonValue mjv = new MappingJacksonValue(new CustomBean("Value1", "Value2", "Value3"));

        mjv.setFilters(filters);

        return mjv;
    }

    @GetMapping("/filteredBean-list")
    public List<CustomBean> filteredBeanList() {
        return Arrays.asList(new CustomBean("Value11", "Value12", "Value13"),
                new CustomBean("Value1", "Value2", "Value3"));
    }
}
