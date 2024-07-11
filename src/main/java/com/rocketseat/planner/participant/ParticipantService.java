package com.rocketseat.planner.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.planner.trip.Trip;

@Service
public class ParticipantService {

    @Autowired
    public ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip) {
        List<Participant> participants = new ArrayList<>();

        for (String email : participantsToInvite) {
            participants.add(new Participant(email, trip));
        }

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip) {
        Participant newParticipant = new Participant(email, trip);

        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public List<ParticipantData> getAllParticipantsFromEvent(UUID tripId) {
        return repository.findByTripId(tripId).stream().map(participant -> new ParticipantData(participant.getId(),
                participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId) {
    }

    public void triggerConfirmationEmailToParticipant(String email) {

    }

}
