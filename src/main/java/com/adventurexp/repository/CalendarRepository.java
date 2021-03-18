package com.adventurexp.repository;

import com.adventurexp.model.PlannedActivities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<PlannedActivities, Long> {
}
