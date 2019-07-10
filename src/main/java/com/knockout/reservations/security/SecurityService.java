package com.knockout.reservations.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class SecurityService {

    String authenticatorURI = "http://localhost:8081";

    public boolean validateJwt(String jwt) throws MalformedURLException {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity response = restTemplate.postForEntity(
                new URL(authenticatorURI + "/validateJwt").toString(),
                jwt, String.class);
        return response.getStatusCode().equals(HttpStatus.OK);
    }
}
