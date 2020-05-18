package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Societe;
@Service
public interface SocieteService {
	
	List<Societe> findAll();
	Societe findById(String id);
	Societe add(Societe societe);
	Societe update(Societe societe);
	void deleteById(String id);
}
