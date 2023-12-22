package com.example.datafetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.example")
public class DatafetcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatafetcherApplication.class, args);
	}

}
