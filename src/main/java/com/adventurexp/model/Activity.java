package com.adventurexp.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;

    private String actName;
    private String actDescription;
    private String employeeId;

    @OneToMany
    @JoinColumn(name = "activity_act_id")
    private Set<Booking> plannedActivities = new HashSet<>();

    public Activity() {
    }

    public Activity(Long actId, String actName, String actDescription, String actInstructor) {
        this.actId = actId;
        this.actName = actName;
        this.actDescription = actDescription;
        this.employeeId = actInstructor;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + actId +
                ", activityName='" + actName + '\'' +
                ", activityDescription='" + actDescription + '\'' +
                ", instructor='" + employeeId + '\'' +
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String instructor) {
        this.employeeId = instructor;
    }
}

