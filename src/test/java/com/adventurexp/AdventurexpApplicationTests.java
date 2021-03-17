package com.adventurexp;

import com.adventurexp.model.Activity;
import com.adventurexp.repository.ActivityRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class AdventurexpApplicationTests {

    @MockBean
    private ActivityRepository activityRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void activityFindAllTest(){

        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1L,"Minigolf","Hole in one", "magnus"));
        list.add(new Activity(2L,"Paintball","Bulls eye", "Jean"));
        list.add(new Activity(3L,"Sumo wrestling","Grab'n'go", "Malene"));

        Mockito.when(activityRepository.findAll()).thenReturn(list);

        System.out.println(list);
    }

}
