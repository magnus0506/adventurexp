package com.adventurexp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Activity {

    private final String activity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long act_id;

    public Activity(String activity) {
        this.activity = activity;


    }


    public Activity() {

    }
}

