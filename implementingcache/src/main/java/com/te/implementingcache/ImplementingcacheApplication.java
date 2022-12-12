package com.te.implementingcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ImplementingcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementingcacheApplication.class, args);
	}

}
