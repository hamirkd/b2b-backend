package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Participant;
@Service
public interface ParticipantService {
	
	List<Participant> findAll();
	Participant findById(String id);
	Participant add(Participant t);
	Participant update(Participant t);
	void deleteById(String id);
}
