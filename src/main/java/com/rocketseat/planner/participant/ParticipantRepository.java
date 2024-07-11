package com.rocketseat.planner.participant;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    public List<Participant> findByTripId(UUID id);
}
