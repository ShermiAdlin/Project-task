package com.te.jsypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class JsyptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsyptApplication.class, args);
	}

}
