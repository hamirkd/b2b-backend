package com.b2b.b2b.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Competence;

@Repository
public interface CompetenceRepository extends MongoRepository<Competence, String> {
}
