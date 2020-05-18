package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Pays;
import com.b2b.b2b.repositories.PaysRepository;
@Service
public class PaysServiceImpl implements PaysService{
	@Autowired
	  PaysRepository paysRepository;

	@Override
	public List<Pays> findAll() {
		
		return paysRepository.findAll();
	}

	@Override
	public Pays findById(String id) {
		
		return paysRepository.findById(id).get();
	}

	@Override
	public Pays add(Pays t) {
		
		return paysRepository.save(t);
	}

	@Override
	public Pays update(Pays t) {
		
		return paysRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		paysRepository.deleteById(id);
	}
	
}
