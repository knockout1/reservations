package com.knockout.reservations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/court")
@RestController
public class CourtReservationController {

    @GetMapping("/{id}")
    public String geReservation(@PathVariable String id) {
        return "Reservation for court " + id;
    }
}
