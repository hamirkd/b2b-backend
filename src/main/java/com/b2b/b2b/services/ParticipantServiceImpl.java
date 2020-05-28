package com.b2b.b2b.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.dto.CompetenceDto;
import com.b2b.b2b.dto.ParticipantDto;
import com.b2b.b2b.menum.TypeProfil;
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
	@Autowired
	CompetenceService competenceService;
	@Autowired
	PaysService paysService;
	

	@Override
	public List<Participant> findAll() {
		
		return participantRepository.findAll();
	}

	@Override
	public Participant findById(String id) {
		
		return participantRepository.findById(id).get();
	}

	@Override
	public Participant add(ParticipantDto t) {
		if(this.utilisateurRepository.findByLogin(t.getLogin())==null)
		{
			Participant p=new Participant();
			p.setEmail(t.getEmail());
			p.setLogin(t.getLogin());
			p.setPassword(t.getPassword());
			p.setNom(t.getNom());
			p.setPrenom(t.getPrenom());
			p.setFonction(t.getFonction());
			p.setTelephone(t.getTelephone());
			p.setTelephonePortable(t.getTelephonePortable());
			p.setEtatCivil(t.getEtatCivil());
			p.setActiverPlanning(t.isActiverPlanning());
			if(t.getPays()!=null) {
				p.setPays(paysService.findById(t.getPays().getId()));
			}
			p.setCompetences(new ArrayList());
			for(CompetenceDto c:t.getCompetences()) {
				p.getCompetences().add(competenceService.findById(c.getId()));
			}
			return participantRepository.save(p);
		}
		return null;
	}

	@Override
	public Participant add(Participant t) {
		if(this.utilisateurRepository.findByLogin(t.getLogin())==null)
		{
			Utilisateur u = new Utilisateur();
			u.setLogin(t.getLogin());
			u.setPassword(t.getPassword());
			u.setProfil(t.getProfil());
			u.setNom(t.getNom());

			if(t.getProfil()==TypeProfil.PARTICIPANT) {
			utilisateurRepository.save(u);
			return participantRepository.save(t);}
			else utilisateurRepository.save(u);
		}
		return null;
	}

	@Override
	public Participant update(Participant t) {
			return participantRepository.save(t);
	}
	
	@Override
	public Utilisateur login(Participant t) {
		for(Utilisateur u:utilisateurRepository.findAll()) {
			if(u.getPassword().compareTo(t.getPassword())==0&&u.getLogin().compareToIgnoreCase(t.getLogin())==0)
				return u;
		}
		return null;
	}
	@Override
	public Participant findByLogin(Participant t) {
		for(Participant u:participantRepository.findAll()) {
			if(u.getLogin().compareToIgnoreCase(t.getLogin())==0)
				return u;
		}
		return null;
	}
	@Override
	public Participant findByLogin(String t) {
		for(Participant u:participantRepository.findAll()) {
			if(u.getLogin().compareToIgnoreCase(t)==0)
				return u;
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		
		participantRepository.deleteById(id);
	}
	
}
