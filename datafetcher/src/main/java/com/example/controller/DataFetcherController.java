package com.example.controller;

import com.example.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/data")
public class DataFetcherController {

    private final KafkaProducer kafkaProducer;
    DataFetcherController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }
    @GetMapping("welcome")
    public String test()
    {
        return "test";
    }

}


