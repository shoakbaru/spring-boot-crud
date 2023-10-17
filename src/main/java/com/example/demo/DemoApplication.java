package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@EntityScan("com.example")
@SpringBootApplication()
@EnableScheduling
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Scheduled(fixedRate = 1000L)
//	public void startRate() {
//		System.out.println("New rate " + new Date());
//	}
//
//	@Scheduled(fixedDelay = 1000L)
//	public void startDelay() {
//		System.out.println("New delay " + new Date());
//	}

	@Scheduled(cron = "0 30 18 * * *")
	public void startCron() {
		System.out.println("New cron " + new Date());
	}

}
