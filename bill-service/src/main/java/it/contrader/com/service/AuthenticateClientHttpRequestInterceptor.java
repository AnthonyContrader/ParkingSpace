package it.contrader.com.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import it.contrader.com.security.SecurityUtils;

@Component
public class AuthenticateClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        //Optional<String> token = SecurityUtils.getCurrentUserJWT();
        //System.out.println("Token::::::::"+token);
        httpRequest.getHeaders().add("Authorization","Bearer "+"");
        return clientHttpRequestExecution.execute( httpRequest, bytes );
    }
}