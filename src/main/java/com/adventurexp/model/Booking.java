package com.adventurexp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date")
    private Date bookingDate;

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

    public int getParticipantCount() {
        return participantCount;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
