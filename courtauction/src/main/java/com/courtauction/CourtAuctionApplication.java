package com.courtauction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan("com.courtauction")
@EnableMongoRepositories(basePackages = "com.courtauction.dao")
public class CourtAuctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourtAuctionApplication.class, args);
    }

}
