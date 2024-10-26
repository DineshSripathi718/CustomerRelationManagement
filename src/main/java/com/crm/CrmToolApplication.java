package com.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com")
@ComponentScan(basePackages = "com")
public class CrmToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmToolApplication.class, args);
		System.out.println("CrmToolApplication Started");
	}

}
