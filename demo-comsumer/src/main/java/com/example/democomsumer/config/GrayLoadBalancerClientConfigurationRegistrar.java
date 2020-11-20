package com.example.democomsumer.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientSpecification;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lengleng
 * @date 2020/11/20
 */
public class GrayLoadBalancerClientConfigurationRegistrar implements ImportBeanDefinitionRegistrar {


    private static void registerClientConfiguration(BeanDefinitionRegistry registry, Object name,
                                                    Object configuration) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .genericBeanDefinition(LoadBalancerClientSpecification.class);
        builder.addConstructorArgValue(name);
        builder.addConstructorArgValue(configuration);
        registry.registerBeanDefinition(name + ".LoadBalancerClientSpecification", builder.getBeanDefinition());
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        registerClientConfiguration(registry, "demo-provider", GrayLoadBalancerConfig.class);
    }
}
