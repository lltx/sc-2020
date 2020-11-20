package com.example.democomsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lengleng
 * @date 2020/11/20
 */
@FeignClient(contextId = "DSAD", name = "demo-provider")
public interface DemoFeignClient {

    @GetMapping("/rest")
    String demo();
}
