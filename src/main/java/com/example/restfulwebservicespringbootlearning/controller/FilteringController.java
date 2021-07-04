package com.example.restfulwebservicespringbootlearning.controller;

import java.util.Arrays;
import java.util.List;

import com.example.restfulwebservicespringbootlearning.entity.SomeBean;

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
}
