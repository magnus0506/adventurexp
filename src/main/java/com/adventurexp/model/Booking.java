package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date")
    private Date bookingDate;

    @JsonFormat(pattern = "hh:mm")
    @Column(name = "booking_time")
    private Timestamp bookingTime;

    @Column(name = "participant_count")
    private int participantCount;

    @ManyToOne
    @JoinColumn(name = "act_id")
    private Activity activity;

    public Long getBookingId() {
        return bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
