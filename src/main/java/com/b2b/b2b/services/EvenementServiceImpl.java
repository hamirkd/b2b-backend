package com.b2b.b2b.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.repositories.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService{
	@Autowired
	  EvenementRepository evenementRepository;

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
		return evenementRepository.save(t);
	}

	@Override
	public Evenement update(Evenement t) {
		t.setDateModification(LocalDateTime.now());
		return evenementRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		evenementRepository.deleteById(id);
	}
	
}
