package com.adventurexp.controller;


import com.adventurexp.repositories.ActivityRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Lazy
@Controller

public class ActivityController {

    private ActivityRepository activityRepository;

    public ActivityController(ActivityController activityController, ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }



    @RequestMapping("/activities")
    public String getActivities(Model model, String activity) {
        model.addAttribute("Activities", activityRepository.findAll());
        return activity;
    }
}
