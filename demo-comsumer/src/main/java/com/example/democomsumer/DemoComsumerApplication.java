package com.example.democomsumer;

import com.example.democomsumer.config.GrayLoadBalancerClientConfigurationRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import(GrayLoadBalancerClientConfigurationRegistrar.class)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class DemoComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoComsumerApplication.class, args);
	}

}
