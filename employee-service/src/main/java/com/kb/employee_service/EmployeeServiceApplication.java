package com.kb.employee_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// documentation on swagger ui
@OpenAPIDefinition(
		info = @Info(
				title  = "Employee Microservice",
				description = "Employee Microservicefor UKG Training",
				summary = "Employee CRUD Operations",
				contact = @Contact(
						name = "Kalpana Bishnoi",
						email = "kalpana.bishnoi@ukg.com"
				)
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class EmployeeServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
