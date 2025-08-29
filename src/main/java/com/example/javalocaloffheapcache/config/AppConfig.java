package com.example.javalocaloffheapcache.config;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EhcacheCachingProvider getEhcacheCachingProvider() {
        return new EhcacheCachingProvider();
    }
}
