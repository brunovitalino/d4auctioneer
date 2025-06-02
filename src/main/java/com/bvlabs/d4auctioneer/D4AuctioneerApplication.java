package com.bvlabs.d4auctioneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class D4AuctioneerApplication {

	public static void main(String[] args) {
		SpringApplication.run(D4AuctioneerApplication.class, args);
	}

}
