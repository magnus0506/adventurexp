package com.adventurexp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_firstname")
    private String employeeFirstname;

    @Column(name = "employee_lastname")
    private String employeeLastname;

    @OneToMany
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    @JsonIgnore
    private Set<Activity> activities = new HashSet<>();

    public Employee() {
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }
}
