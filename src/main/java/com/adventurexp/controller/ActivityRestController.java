package com.adventurexp.controller;

import com.adventurexp.model.Activity;
import com.adventurexp.model.Booking;
import com.adventurexp.repository.BookingRepository;
import com.adventurexp.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityRestController {

    private final ActivityRepository activityRepository;
    private final BookingRepository bookingRepository;

    public ActivityRestController(ActivityRepository activityRepository, BookingRepository bookingRepository) {
       this.bookingRepository = bookingRepository;
        this.activityRepository = activityRepository;

    }

    @GetMapping("/activities")
    public List<Activity> findAllActivity() {
        List<Activity> activity;
        activity = activityRepository.findAll();
        return activity;
    }

    @GetMapping("/booking")
    public List<Booking> findAllBookings() {
        List<Booking> bookingList;
        bookingList = bookingRepository.findAll();
        return bookingList;
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

    @GetMapping("/booking/{act_id}")
    public ResponseEntity<Booking> findBookedActivity(@PathVariable Long act_id) {
        Optional<Booking> booking = bookingRepository.findById(act_id);
        if (booking.isPresent()) {
            Booking booking1 = booking.get();
            return new ResponseEntity<>(booking1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/booking/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking postActivity(@RequestBody Booking activity) {
        return bookingRepository.save(activity);
    }

    @PostMapping(value = "/activities/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }


}

