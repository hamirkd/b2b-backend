package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Utilisateur;
@Service
public interface UtilisateurService {
	List<Utilisateur> findAll();
	Utilisateur findById(String id);
	Utilisateur add(Utilisateur utilisateur);
	Utilisateur update(Utilisateur utilisateur);
	void deleteById(String id);
}
