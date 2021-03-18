package com.adventurexp.repository;

import com.adventurexp.model.PlannedActivities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlannedRepository extends JpaRepository<PlannedActivities, Long> {
}
