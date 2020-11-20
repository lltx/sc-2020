package com.example.democomsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultRequestContext;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;

/**
 * @author lengleng
 * @date 2020/11/20
 */
@Slf4j
public class GrayRoundRobinLoadBalancer extends RoundRobinLoadBalancer {
    /**
     * @param serviceInstanceListSupplierProvider a provider of
     *                                            {@link ServiceInstanceListSupplier} that will be used to get available instances
     * @param serviceId                           id of the service for which to choose an instance
     */
    public GrayRoundRobinLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        super(serviceInstanceListSupplierProvider, serviceId);
    }

    /**
     * @param serviceInstanceListSupplierProvider a provider of
     *                                            {@link ServiceInstanceListSupplier} that will be used to get available instances
     * @param serviceId                           id of the service for which to choose an instance
     * @param seedPosition                        Round Robin element position marker
     */
    public GrayRoundRobinLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId, int seedPosition) {
        super(serviceInstanceListSupplierProvider, serviceId, seedPosition);
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        DefaultRequestContext requestContext = (DefaultRequestContext) request.getContext();

        feign.Request feignReq = (feign.Request) requestContext.getClientRequest();

        Map<String, Collection<String>> headers = feignReq.headers();
        return super.choose(request);
    }

}
