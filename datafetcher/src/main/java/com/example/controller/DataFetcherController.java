package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/data")
public class DataFetcherController {

    @GetMapping("welcome")
    public String test()
    {
        return "test";
    }
}
