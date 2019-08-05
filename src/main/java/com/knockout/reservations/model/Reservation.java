package com.knockout.reservations.model;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;
    private Integer courtId;
    private DateTime dateTime;

    protected Reservation() {

    }

    public Reservation(Integer reservationId, Integer courtId, DateTime dateTime) {
        this.reservationId = reservationId;
        this.courtId = courtId;
        this.dateTime = dateTime;
    }

    public Reservation(Integer courtId, DateTime dateTime) {
        this.courtId = courtId;
        this.dateTime = dateTime;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    @Override public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", courtId=" + courtId +
                ", dateTime=" + dateTime +
                '}';
    }

}
