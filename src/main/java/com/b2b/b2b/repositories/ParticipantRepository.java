package com.b2b.b2b.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Participant;

@Repository
public interface ParticipantRepository extends MongoRepository<Participant, String> {
}
