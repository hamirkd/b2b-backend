package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.RendezVous;

@Service
public interface RendezVousService {
	
	List<RendezVous> findAll();
	RendezVous findById(String id);
	RendezVous add(RendezVous rendezVous);
	RendezVous update(RendezVous rendezVous);
	void deleteById(String id);
	List<RendezVous>findByParticipant(String login);
	List<RendezVous>findByEvenement(String evenementId);
	List<RendezVous>sauvegarderGeneration(List<RendezVous>rendezVousList);
}
