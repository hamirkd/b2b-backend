package com.b2b.b2b.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
	public Utilisateur findByLoginAndPassword(String login,String password);
	public Utilisateur findByLogin(String login);
}
