package com.adventurexp.model;
import javax.persistence.*;


@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;

    private String actName;
    private String actDescription;
    private String actInstructor;

    public Activity() {
    }

    public Activity(Long actId, String actName, String actDescription, String actInstructor) {
        this.actId = actId;
        this.actName = actName;
        this.actDescription = actDescription;
        this.actInstructor = actInstructor;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + actId +
                ", activityName='" + actName + '\'' +
                ", activityDescription='" + actDescription + '\'' +
                ", instructor='" + actInstructor + '\'' +
                '}';
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long id) {
        this.actId = id;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String activityName) {
        this.actName = activityName;
    }

    public String getActDescription() {
        return actDescription;
    }

    public void setActDescription(String activityDescription) {
        this.actDescription = activityDescription;
    }

    public String getActInstructor() {
        return actInstructor;
    }

    public void setActInstructor(String instructor) {
        this.actInstructor = instructor;
    }
}

