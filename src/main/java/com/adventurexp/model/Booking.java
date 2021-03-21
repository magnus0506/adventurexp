package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String bookingDate;
    private int participantCount;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "actId")
    private Activity activity;


    public Booking() {
    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long calendarId) {
        this.bookingId = calendarId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String calendarDate) {
        this.bookingDate = calendarDate;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
