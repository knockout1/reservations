package com.knockout.reservations;

import com.knockout.reservations.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/court")
@RestController
public class CourtReservationController {

    private ReservationRepository reservationRepository;

    public CourtReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

        reservationRepository.save(new Reservation(1, 1, new Date()));
        reservationRepository.save(new Reservation(2, 2, new Date()));
    }

    @GetMapping("/{id}")
    public String geReservation(@PathVariable String id) {
        return "Reservation for court " + id;
    }

    @GetMapping("/")
    public String getAllReservations() {
        return "All reservations " + reservationRepository.findAll().toString();
    }
}
