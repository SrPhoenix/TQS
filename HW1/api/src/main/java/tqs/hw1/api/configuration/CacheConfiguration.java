package tqs.hw1.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tqs.hw1.api.service.Cache;

@Configuration
public class CacheConfiguration {
    @Bean
    Cache myService() {
        return new Cache();
    }
}