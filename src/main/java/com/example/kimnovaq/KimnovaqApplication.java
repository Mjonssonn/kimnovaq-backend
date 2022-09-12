package com.example.kimnovaq;

import com.example.kimnovaq.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.kimnovaq.*"})
public class KimnovaqApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimnovaqApplication.class, args);
	}
}
