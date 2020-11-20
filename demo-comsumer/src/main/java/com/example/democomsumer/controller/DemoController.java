package com.example.democomsumer.controller;

import com.example.democomsumer.feign.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
public class DemoController {

    private final DiscoveryClient discoveryClient;

    private final DemoFeignClient  demoFeignClient;

    @GetMapping("/rest")
    public String rest() {
        return demoFeignClient.demo();
    }
}
