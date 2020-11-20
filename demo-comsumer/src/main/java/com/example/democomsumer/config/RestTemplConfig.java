package com.example.democomsumer.config;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lengleng
 * @date 2020/11/20
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplConfig {
    @Bean
    public RequestInterceptor grayFeignRequestInterceptor() {
        return new GrayFeignRequestInterceptor();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
