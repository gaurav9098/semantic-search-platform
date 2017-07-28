package com.graph.anveshanam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.graph.anveshanam.domain")
public class ApplicationMain{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}