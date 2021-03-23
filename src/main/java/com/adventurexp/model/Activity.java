package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long actId;

    @Column(name = "act_name")
    private String actName;

    @Column(name = "act_description")
    private String actDescription;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @OneToMany
    @JoinColumn(name = "act_id")
    @JsonIgnore
    private Set<Booking> bookings = new HashSet<>();

    public Activity() {
    }

    public Long getActId() {
        return actId;
    }

    public String getActName() {
        return actName;
    }

    public String getActDescription() {
        return actDescription;
    }

    public String getEmployee() {
        return employee.getEmployeeFirstname();
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

