package com.b2b.b2b.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Societe;
import com.b2b.b2b.repositories.SocieteRepository;

@Service
public class SocieteServiceImpl implements SocieteService{
	@Autowired
	  SocieteRepository societeRepository;

	@Override
	public List<Societe> findAll() {
		
		return societeRepository.findAll();
	}

	@Override
	public Societe findById(String id) {
		
		return societeRepository.findById(id).get();
	}

	@Override
	public Societe add(Societe t) {
		if(t.getId()==null) {
			t.setDateCreation(LocalDateTime.now());
		}
		t.setDateModification(LocalDateTime.now());
		return societeRepository.save(t);
	}

	@Override
	public Societe update(Societe t) {
		t.setDateModification(LocalDateTime.now());
		return societeRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		societeRepository.deleteById(id);
	}
	
}
