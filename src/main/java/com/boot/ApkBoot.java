package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author javahunk
 *
 */
@SpringBootApplication
@EnableAsync
public class ApkBoot {
	public static void main(String[] args) {
		SpringApplication.run(ApkBoot.class, args);
	}
}
