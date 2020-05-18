package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Participant;
import com.b2b.b2b.models.Utilisateur;
import com.b2b.b2b.repositories.ParticipantRepository;
import com.b2b.b2b.repositories.UtilisateurRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService{
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<Participant> findAll() {
		
		return participantRepository.findAll();
	}

	@Override
	public Participant findById(String id) {
		
		return participantRepository.findById(id).get();
	}

	@Override
	public Participant add(Participant t) {
		if(this.utilisateurRepository.findByLogin(t.getLogin())==null)
		{
			return participantRepository.save(t);
		}
		return null;
	}

	@Override
	public Participant update(Participant t) {
		Utilisateur u=this.utilisateurRepository.findByLogin(t.getLogin());
		if(u==null||u.getId()==t.getId())
		{
			return participantRepository.save(t);
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		
		participantRepository.deleteById(id);
	}
	
}
