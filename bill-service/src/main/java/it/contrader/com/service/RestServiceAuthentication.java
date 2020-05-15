package it.contrader.com.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceAuthentication {
	
	public RestTemplate restTemplate;
	
	public RestServiceAuthentication(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.basicAuthorization("admin", "admin").build();
    }
}
