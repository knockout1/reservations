package com.knockout.reservations;

import com.knockout.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/get/{id}")
    public ResponseEntity geReservation(@PathVariable String id) {
        return ResponseEntity
                .ok("Reservation for court " + id + ": " + reservationRepository.findByCourtId(Integer.valueOf(id)));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllReservations() {
        return ResponseEntity.ok("All reservations " + reservationRepository.findAll().toString());
    }

    @PostMapping("/reserve")
    public ResponseEntity reserveCourt(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }

}
