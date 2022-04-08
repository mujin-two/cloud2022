package com.amu.springCloud.lb.impl;

import com.amu.springCloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancer implements LoadBalancer {
    // 访问次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

    private final int getAndIncrement() {
        int cur;
        int next;
        do {
            cur = this.atomicInteger.get();
            next = cur >= Integer.MAX_VALUE ? 0 : cur + 1;
        }while (!this.atomicInteger.compareAndSet(cur,next));
        return next;
    }
}
