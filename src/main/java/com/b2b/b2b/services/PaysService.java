package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Pays;
@Service
public interface PaysService {
	
	List<Pays> findAll();
	Pays findById(String id);
	Pays add(Pays t);
	Pays update(Pays t);
	void deleteById(String id);
}
