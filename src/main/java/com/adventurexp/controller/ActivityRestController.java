package com.adventurexp.controller;

import com.adventurexp.model.Activity;
import com.adventurexp.model.PlannedActivities;
import com.adventurexp.repository.CalendarRepository;
import com.adventurexp.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityRestController {

    private final ActivityRepository activityRepository;
    private final CalendarRepository calendarRepository;

    public ActivityRestController(ActivityRepository activityRepository, CalendarRepository calendarRepository) {
       this.calendarRepository = calendarRepository;
        this.activityRepository = activityRepository;

    }

    @GetMapping("/activities")
    public List<Activity> findAllActivity() {
        List<Activity> activity;
        activity = activityRepository.findAll();
        return activity;
    }

    @GetMapping("/activities/planned")
    public List<PlannedActivities> findAllPlannedActivity() {
        List<PlannedActivities> calendarList;
        calendarList = calendarRepository.findAll();
        calendarList.forEach(act -> System.out.println(
                "activity id= " + act.getActivity().getActId() +
                " activity name= " + act.getActivity().getActName() +
                " act desc=" + act.getActivity().getActDescription()));
        return calendarList;
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

    @PostMapping(value = "/newact", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PlannedActivities postActivity(@RequestBody PlannedActivities activity) {
        System.out.println(activity);
        return calendarRepository.save(activity);
    }
}

