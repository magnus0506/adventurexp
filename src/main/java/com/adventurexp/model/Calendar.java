package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarId;



    @ManyToOne
    @JsonBackReference
    private Activity activity;


    public Calendar() {
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "calendarID=" + calendarId + '}';
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
