package com.rocketseat.planner.activity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {
    public List<Activity> findByTripId(UUID id);

}
