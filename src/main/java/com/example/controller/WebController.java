package com.example.controller;
import com.example.config.LogMethodName;
import com.example.config.MonitorTime;
import com.example.config.RetryOperation;
import com.example.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class WebController {

    @Autowired
    private FibonacciService fibonacciService;

    @Cacheable("Fibonacci")
    @LogMethodName
    @MonitorTime
    @GetMapping(path = "/api/fibonacci/{number}")
    public Long fibonacci(@PathVariable(value = "number") Long number) {
        return fibonacciService.nthFibonacciTerm(number);
    }

    @RetryOperation
    @LogMethodName
    @PostMapping(path = "/api/storeData")
    public void storeData(@RequestParam(value = "data") String data) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        } else {
            System.out.println("Pretend everything went fine");
        }
    }
}
