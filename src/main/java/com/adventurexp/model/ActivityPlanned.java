package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activities_planned")
public class ActivityPlanned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actPlId;

    @ManyToOne
//    @JsonBackReference
    @JoinTable(name = "activities", joinColumns = @JoinColumn(name = "actId"))
    private Activity activity;


    public ActivityPlanned() {
    }

    @Override
    public String toString() {
        return "ActivityPlanned{" +
                "actId=" + actPlId +
                '}';
    }

//    public Activity getActivity() {
//        return activity;
//    }
//
//    public void setActivity(Activity activity) {
//        this.activity = activity;
//    }

    public Long getActPlId() {
        return actPlId;
    }

    public void setActPlId(Long actId) {
        this.actPlId = actId;
    }
}
