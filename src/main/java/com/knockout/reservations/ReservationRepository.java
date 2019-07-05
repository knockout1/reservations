package com.knockout.reservations;

import com.knockout.reservations.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByCourtId(Integer courtId);

}
