package com.b2b.b2b.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.models.Participant;
import com.b2b.b2b.repositories.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService{
	@Autowired
	  EvenementRepository evenementRepository;
	@Autowired
	ParticipantService participantService;

	@Override
	public List<Evenement> findAll() {
		
		return evenementRepository.findAll();
	}

	@Override
	public Evenement findById(String id) {
		
		return evenementRepository.findById(id).get();
	}

	@Override
	public Evenement add(Evenement t) {
		t.setDateCreation(LocalDateTime.now());
		t.setDateModification(LocalDateTime.now());
		t.setParticipants(new ArrayList<>());
		return evenementRepository.save(t);
	}

	@Override
	public Evenement update(Evenement t) {
		t.setDateModification(LocalDateTime.now());
		return evenementRepository.save(t);
	}

	public Evenement addOrDeleteParticipant(String id,String login) {
		
		Evenement e=findById(id);
		e.setDateModification(LocalDateTime.now());
		System.out.println(login);
		Participant p=participantService.findByLogin(login);
		p.setLogin(null);
		if(e.getParticipants().isEmpty()) {
			e.setParticipants(new ArrayList<Participant>());
			e.getParticipants().add(p);
		}
		else if(e.getParticipants().contains(p)){
			e.getParticipants().remove(p);
		}
		else {
			e.getParticipants().add(p);
		}
		return evenementRepository.save(e);
	}

	@Override
	public void deleteById(String id) {
		
		evenementRepository.deleteById(id);
	}
	
	@Override
	public List<Evenement> findEvenementByParticipant(String participantId) {
		List<Evenement>evenements = evenementRepository.findAll();
		List<Evenement> bonListe = new ArrayList<>();
		for (Evenement evenement : evenements) {
			for (Participant participant : evenement.getParticipants()) {
				if(participant.getId().compareToIgnoreCase(participantId)==0) {bonListe.add(evenement);break;}
			}
		}
		return bonListe;
	}
	
}
