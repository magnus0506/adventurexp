package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "activities_planned")
public class PlannedActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plannedId;

    private String plannedDate;
    private int participantCount;


    @ManyToOne
    private Activity activity;


    public PlannedActivities() {
    }


    @Override
    public String toString() {
        return "PlannedActivities{\n" +
                "planned id= " + plannedId + '\n' +
                "activity date= '" + plannedDate + '\n' +
                "participantCount=" + participantCount + '\n' +
                "activity=" + activity + '\n' +
                '}';
    }

    public Long getPlannedId() {
        return plannedId;
    }

    public void setPlannedId(Long calendarId) {
        this.plannedId = calendarId;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String calendarDate) {
        this.plannedDate = calendarDate;
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
