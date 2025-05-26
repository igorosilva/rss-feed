package com.example.rssFeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@EnableMongoAuditing
@SpringBootApplication
@EnableMongoRepositories
public class RssFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssFeedApplication.class, args);
	}

}
