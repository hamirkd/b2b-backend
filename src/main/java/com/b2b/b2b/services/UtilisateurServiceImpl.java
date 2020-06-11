package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Utilisateur;
import com.b2b.b2b.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	@Autowired
	  UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> findAll() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findById(String id) {
		
		return utilisateurRepository.findById(id).get();
	}

	@Override
	public Utilisateur add(Utilisateur t) {
		
		return utilisateurRepository.save(t);
	}

	@Override
	public Utilisateur update(Utilisateur t) {
		
		return utilisateurRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		utilisateurRepository.deleteById(id);
	}
	
}
