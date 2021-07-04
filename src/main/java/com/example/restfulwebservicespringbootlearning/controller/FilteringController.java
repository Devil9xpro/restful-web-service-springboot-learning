package com.example.restfulwebservicespringbootlearning.controller;

import java.util.Arrays;
import java.util.List;

import com.example.restfulwebservicespringbootlearning.entity.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class FilteringController {

    @GetMapping(value = "/filtering")
    public SomeBean retrieveSomeBean() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping(value = "/filtering-list")
    public List<SomeBean> retrieveListOfSomeBean() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));
    }

    // return only field1, field2
    @GetMapping(value = "/dynamicFiltering")
    public MappingJacksonValue retrieveSomeBeanDynamic() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1, field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping(value = "/dynamicFiltering-list")
    public MappingJacksonValue retrieveListOfSomeBeanDynamic() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1, field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }
}
