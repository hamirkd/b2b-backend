package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.dto.ParticipantDto;
import com.b2b.b2b.models.Participant;
import com.b2b.b2b.models.Utilisateur;
@Service
public interface ParticipantService {
	
	List<Participant> findAll();
	Participant findById(String id);
	Participant add(ParticipantDto t);
	Participant add(Participant t);
	Utilisateur login(Participant t);
	Participant findByLogin(Participant t);
	Participant findByLogin(String t);
	Participant update(Participant t);
	void deleteById(String id);
}
