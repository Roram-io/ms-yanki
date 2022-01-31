package com.nttdata.msyanki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MsYankiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsYankiApplication.class, args);
	}

}
