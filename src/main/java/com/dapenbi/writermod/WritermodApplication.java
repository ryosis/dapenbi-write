package com.dapenbi.writermod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WritermodApplication {

	public static void main(String[] args) {
		SpringApplication.run(WritermodApplication.class, args);
	}

}
