package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Langue;
import com.b2b.b2b.repositories.LangueRepository;
@Service
public class LangueServiceImpl implements LangueService{
	@Autowired
	  LangueRepository langueRepository;
	
	@Override
	public List<Langue> findAllLangue() {
		return langueRepository.findAll();
	}
	@Override
	public Langue findById(String id) {
		return langueRepository.findById(id).get();
	}
}
