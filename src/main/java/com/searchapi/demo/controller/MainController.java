package com.searchapi.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @GetMapping("/hello")
    public  String hello() {
        return "Hello, World";
    }

    @PostMapping("/numbers")
    public ResponseEntity<String> processNumber(@RequestBody List<Integer> numbers) {

        return ResponseEntity.ok("Numbers recieved:" + numbers.toString());
    }
}
