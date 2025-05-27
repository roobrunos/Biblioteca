package com.rodrigo.bibliotecan1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.rodrigo.bibliotecan1")

public class Bibliotecan1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bibliotecan1Application.class, args);
	}

}
