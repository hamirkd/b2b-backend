package com.b2b.b2b.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>  {
	public Utilisateur findByLoginAndPassword(String login,String password);
	@Query("{ 'login' : ?0 }")
	public Utilisateur findByLogin(String login);
	
}
