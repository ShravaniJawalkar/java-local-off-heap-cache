package com.example.javalocaloffheapcache.config;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AppConfig {
    @Bean
    public CacheManager ehCacheManager() {
        return CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("testcache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                    String.class, String.class,
                    ResourcePoolsBuilder.newResourcePoolsBuilder()
                        .offheap(5, MemoryUnit.MB)
                )
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(3600)))
            )
            .build(true);
    }
}
