package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.models.Participant;
@Service
public interface EvenementService {
	
	List<Evenement> findAll();
	Evenement findById(String id);
	Evenement add(Evenement t);
	Evenement update(Evenement t);
	void deleteById(String id);
	public Evenement addOrDeleteParticipant(String id,String login);
	List<Evenement> findEvenementByParticipant(String participantId);
}
