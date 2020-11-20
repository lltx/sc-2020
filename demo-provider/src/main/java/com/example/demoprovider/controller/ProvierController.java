package com.example.demoprovider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2020/11/20
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class ProvierController {


    @GetMapping("/rest")
    public String rest() {
        return "hello";
    }
}
