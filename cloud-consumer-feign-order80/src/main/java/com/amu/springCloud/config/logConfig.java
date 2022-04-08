package com.amu.springCloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class logConfig {
    @Bean
    Logger.Level getLogLogger() {
        return Logger.Level.FULL;
    }
}
