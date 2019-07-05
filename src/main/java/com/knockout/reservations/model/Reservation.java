package com.knockout.reservations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;
    private Integer courtId;
    private Date dateTime;

    protected Reservation() {

    }

    public Reservation(Integer reservationId, Integer courtId, Date dateTime) {
        this.reservationId = reservationId;
        this.courtId = courtId;
        this.dateTime = dateTime;
    }

    public Reservation(Integer courtId, Date dateTime) {
        this.courtId = courtId;
        this.dateTime = dateTime;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
