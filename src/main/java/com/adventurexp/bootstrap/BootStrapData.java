package com.adventurexp.bootstrap;


import com.adventurexp.bootstrap.BootStrapData;
import com.adventurexp.repositories.ActivityRepository;
import org.springframework.boot.CommandLineRunner;


public class BootStrapData implements CommandLineRunner {

    private final ActivityRepository activityRepository;


    public BootStrapData(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        }

    @Override
    public void run(String... args) throws Exception {

    }

    // @Override
   }


