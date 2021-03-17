package com.adventurexp.controller;


import com.adventurexp.model.Activity;
import com.adventurexp.repositories.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ActivityRestController {

    private final ActivityRepository activityRepository;

    public ActivityRestController(ActivityRepository activityRepository) {
        //, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.activityRepository = activityRepository;
        //this.publisherRepository = publisherRepository;
        //this.authorRepository = authorRepository;
    }

    @GetMapping("/activities")
    public List<Activity> findAllActivity() {
        List<Activity> activity = new ArrayList<>();
        activity = activityRepository.findAll();
        return activity;
    }


    // activity
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

    // new activity

    @PostMapping(value = "/newact", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity) {
        System.out.println(activity);
        return activityRepository.save(activity);


    }

}

