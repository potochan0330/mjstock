package com.poto.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/stockprice")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}