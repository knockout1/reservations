package com.knockout.reservations.security;

import com.knockout.reservations.DiscoveryClientController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class SecurityService {

    private DiscoveryClientController discoveryClientController;

    public SecurityService(DiscoveryClientController discoveryClientController) {
        this.discoveryClientController = discoveryClientController;
    }

    public boolean validateJwt(String jwt) throws MalformedURLException {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity response = restTemplate.postForEntity(
                new URL(discoveryClientController.serviceUrl("authenticator").get() + "/validateJwt").toString(),
                jwt, String.class);
        return response.getStatusCode().equals(HttpStatus.OK);
    }
}
