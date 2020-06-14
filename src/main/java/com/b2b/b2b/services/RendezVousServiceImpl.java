package com.b2b.b2b.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.RendezVous;
import com.b2b.b2b.repositories.RendezVousRepository;

@Service
public class RendezVousServiceImpl implements RendezVousService {
	@Autowired
	RendezVousRepository rendezVousRepository;
	@Autowired
	EvenementService evenementService;

	@Override
	public List<RendezVous> findAll() {
		return rendezVousRepository.findAll();
	}

	@Override
	public RendezVous findById(String id) {
		return rendezVousRepository.findById(id).get();
	}

	@Override
	public RendezVous add(RendezVous rendezVous) {
		return rendezVousRepository.save(rendezVous);
	}

	@Override
	public RendezVous update(RendezVous rendezVous) {
		return rendezVousRepository.save(rendezVous);
	}

	@Override
	public void deleteById(String id) {
		rendezVousRepository.deleteById(id);
	}

	@Override
	public List<RendezVous> findByEvenement(String evenementId) {
		List<RendezVous>liste = new ArrayList<>();
		for(RendezVous rdv:findAll()) {
			if(evenementId.compareTo(rdv.getEvenement().getId())==0) {
				liste.add(rdv);
			}
		}
		return liste;
	}

	@Override
	public List<RendezVous> findByParticipant(String login) {
		List<RendezVous>liste = new ArrayList<>();
		for(RendezVous rdv:findAll()) {
			if(login.compareTo(rdv.getParticipant1().getLogin())==0||login.compareTo(rdv.getParticipant2().getLogin())==0) {
				liste.add(rdv);
			}
		}
		return liste;
	}
	
	@Override
	public List<RendezVous> sauvegarderGeneration(List<RendezVous> rendezVousList) {
		String evenementId=rendezVousList.get(0).getEvenement().getId();
		for(RendezVous rv : findByEvenement(evenementId)) {
			this.rendezVousRepository.deleteById(rv.getId());
		}
		return this.rendezVousRepository.saveAll(rendezVousList);
	}

}
