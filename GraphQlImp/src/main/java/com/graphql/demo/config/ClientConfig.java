package com.graphql.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

	@Bean
	HttpGraphQlClient qlclient() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080/graphql").build();
		return HttpGraphQlClient.builder(client).build();
	}
}
