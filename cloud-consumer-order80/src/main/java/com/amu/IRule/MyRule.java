package com.amu.IRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyRule {
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }
}
