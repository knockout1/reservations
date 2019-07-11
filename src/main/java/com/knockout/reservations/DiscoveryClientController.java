package com.knockout.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Optional<URI> serviceUrl(String serviceName) {
        return discoveryClient.getInstances(serviceName)
                .stream()
                .map(si -> si.getUri())
                .findFirst();
    }
}

