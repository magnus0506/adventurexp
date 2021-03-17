package com.adventurexp.repositories;

import com.adventurexp.model.Activity;
import com.adventurexp.repositories.ActivityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {



}

