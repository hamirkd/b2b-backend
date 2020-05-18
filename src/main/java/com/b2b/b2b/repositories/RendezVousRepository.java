package com.b2b.b2b.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.RendezVous;

@Repository
public interface RendezVousRepository extends MongoRepository<RendezVous, String> {
}
