package br.com.bruno.scrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScrappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrappingApplication.class, args);
	}

}
