package com.b2b.b2b.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.dto.CompetenceDto;
import com.b2b.b2b.dto.ParticipantDto;
import com.b2b.b2b.menum.TypeProfil;
import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.models.Participant;
import com.b2b.b2b.models.RendezVous;
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
	EvenementService evenementService;
	@Autowired
	RendezVousService rendezVousService;
	@Autowired
	PaysService paysService;
	@Autowired
	MailSenderService mailSenderService;
	
	void initData() {

		for(Participant u:participantRepository.findAll()) {
			deleteById(u.getId());
		}	
		for(Utilisateur u:utilisateurRepository.findAll()) {
			utilisateurRepository.deleteById(u.getId());
		}
		for(Evenement e:evenementService.findAll()) {
			evenementService.deleteById(e.getId());
		}
		for(RendezVous rdv:rendezVousService.findAll()) {
			rendezVousService.deleteById(rdv.getId());
		}
		
	}
	

	@Override
	public List<Participant> findAll() {
		
		return participantRepository.findAll();
	}

	@Override
	public Participant findById(String id) throws Exception {
		Optional<Participant> p=participantRepository.findById(id);
		if(p.isPresent())return p.get();
		throw new Exception("Ce participant n'existe pas");
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
			p.setCompetences(new ArrayList<>());
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
			u.setEmail(t.getEmail());
			if(t.getProfil()==TypeProfil.PARTICIPANT) {
			utilisateurRepository.save(u);
			mailSenderService.sendSimpleEmail("daohamadou@gmail.com","Création de compte", 
					"Bonjour, Veuillez recevoir les identifiants de connexion \n Login:"+u.getLogin()
					+"\nMot de passe:"+u.getPassword()
			);
			return participantRepository.save(t);
			}
			else {
				u.setStatus(true);
				utilisateurRepository.save(u);
			}
		}
		return null;
	}

	@Override
	public Utilisateur update(Participant t) {
		Utilisateur u = utilisateurRepository.findByLogin(t.getLogin());
		if(u!=null) {
		u.setStatus(t.isStatus());
		}
		if(t.getProfil()==TypeProfil.ADMINISTRATEUR) {
			return utilisateurRepository.save(u);
		}
		utilisateurRepository.save(u);
			return participantRepository.save(t);
	}
	
	@Override
	public Utilisateur login(Participant t) throws Exception {
		//initData();
		for(Utilisateur u:utilisateurRepository.findAll()) {
			if(u.getPassword().compareTo(t.getPassword())==0&&u.getLogin().compareToIgnoreCase(t.getLogin())==0) {
				if(!u.isStatus()) {
					throw new Exception("COMPTE-PAS-ACTIF");
				}
				return u;
			}
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
