package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Competence;

@Service
public interface CompetenceService {
	List<Competence> findAll();
	Competence findById(String id);
	Competence add(Competence t);
	Competence update(Competence t);
	void deleteById(String id);
}
