package com.b2b.b2b.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.models.Participant;
import com.b2b.b2b.models.RendezVous;
@Repository
public interface RendezVousRepository extends MongoRepository<RendezVous, String> {
	List<RendezVous>findByParticipant1OrParticipant2(Participant participant1,Participant participant2);
	List<RendezVous>findByParticipant1OrParticipant2(String participant1,String participant2);
	List<RendezVous>findRendezVousByEvenement(Evenement evenement);
}
