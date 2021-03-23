package com.adventurexp.controller;

import com.adventurexp.model.Activity;
import com.adventurexp.model.Booking;
import com.adventurexp.model.Employee;
import com.adventurexp.repository.BookingRepository;
import com.adventurexp.repository.ActivityRepository;
import com.adventurexp.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityRestController {

    private final ActivityRepository activityRepository;
    private final BookingRepository bookingRepository;
    private final EmployeeRepository employeeRepository;

    public ActivityRestController(ActivityRepository activityRepository, BookingRepository bookingRepository, EmployeeRepository employeeRepository) {
        this.activityRepository = activityRepository;
        this.bookingRepository = bookingRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/activities")
    public List<Activity> findAllActivity() {

        return activityRepository.findAll();
    }

    @GetMapping("/booking")
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();

    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }


    @GetMapping("/activities/{act_id}")
    public ResponseEntity<Activity> findActivityById(@PathVariable Long act_id) {
        Optional<Activity> activity = activityRepository.findById(act_id);
        if (activity.isPresent()) {
            Activity realactivity = activity.get();
            return new ResponseEntity<>(realactivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/booking/{booking_id}")
    public ResponseEntity<Booking> findBookedActivity(@PathVariable Long booking_id) {
        Optional<Booking> booking = bookingRepository.findById(booking_id);
        if (booking.isPresent()) {
            Booking booking1 = booking.get();
            return new ResponseEntity<>(booking1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/newbooking", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking postBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PostMapping(value = "/newactivity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity newActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }


}

