package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Competence;
import com.b2b.b2b.repositories.CompetenceRepository;

@Service
public class CompetenceServiceImpl implements CompetenceService{
	@Autowired
	  CompetenceRepository competenceRepository;

	@Override
	public List<Competence> findAll() {
		
		return competenceRepository.findAll();
	}

	@Override
	public Competence findById(String id) {
		
		return competenceRepository.findById(id).get();
	}

	@Override
	public Competence add(Competence t) {
		
		return competenceRepository.save(t);
	}

	@Override
	public Competence update(Competence t) {
		
		return competenceRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		competenceRepository.deleteById(id);
	}
	
}
