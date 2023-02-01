package com.izeye.helloworld.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Hello world for Spring Cloud Gateway.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
public class HelloSpringCloudGatewayApplication {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("https://httpbin.org"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringCloudGatewayApplication.class, args);
	}

}
