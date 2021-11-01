package com.codecool.videoserver;

import com.codecool.videoserver.model.Video;
import com.codecool.videoserver.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class VideoServerApplication implements CommandLineRunner {

	private	final VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoServerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		List<Video> videoList = List.of(
				Video.builder()
						.name("Spring Boot Microservices Project - Part 1 - Spring Boot Config Server & Eureka Service Discovery")
						.url("https://www.youtube.com/embed/Fq85GschdLw")
						.build(),
				Video.builder()
						.name("Spring Boot Microservices Project - Part 2 - Spring Cloud Gateway Keycloak Example")
						.url("https://www.youtube.com/embed/9b6OOGMpx5Y")
						.build(),
				Video.builder()
						.name("Spring Boot Microservices Project - Part 3 - Circuit Breaker Resilience4j")
						.url("https://www.youtube.com/embed/LaZGedpfAyM")
						.build(),
				Video.builder()
						.name("Spring Boot Microservices Project - Part 4 - Event Driven Microservices Spring Boot")
						.url("https://www.youtube.com/embed/vUVfKZr0yi8")
						.build(),
				Video.builder()
						.name("Spring Boot Microservices Project - Part 5 - Distributed Tracing Using Sleuth and Zipkin")
						.url("https://www.youtube.com/embed/Y1bIf_A9nPo")
						.build(),
				Video.builder()
						.name("Spring Boot Microservices Project - Part 6 - ELK with spring boot microservices")
						.url("https://www.youtube.com/embed/QZbZDu1xAr8")
						.build()
		);
		videoRepository.saveAll(videoList);
	}
}
