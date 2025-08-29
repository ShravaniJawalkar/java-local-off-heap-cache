package com.example.javalocaloffheapcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavaLocalOffHeapCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLocalOffHeapCacheApplication.class, args);
    }

}
