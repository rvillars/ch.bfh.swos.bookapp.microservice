package ch.bfh.swos.bookapp.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BookAuthorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAuthorServiceApplication.class, args);
	}
}
