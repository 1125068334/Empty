package com.fujl.spring.controller;


import com.fujl.spring.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/ctl")
@RestController
public class AController {


    @Autowired
    private AService aService;

    @GetMapping(path = "/hello")
    public String firstRequest(){
        return "Hello World";
    }
}
