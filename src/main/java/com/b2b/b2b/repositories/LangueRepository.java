package com.b2b.b2b.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Langue;

@Repository
public interface LangueRepository extends MongoRepository<Langue, String> {
	public Langue findByNom(String nom);
}
