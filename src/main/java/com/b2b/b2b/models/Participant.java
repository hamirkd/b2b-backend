package com.b2b.b2b.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "participants")
@Data
public class Participant extends Utilisateur{

	  private String prenom;
	  private String fonction;
	  private String email;
	  private String telephone;
	  private String telephonePortable;
	  private String activerPlanning;
	  @DBRef
	  private Pays pays;
	  @DBRef
	  private Societe societe;
	  @DBRef
	  private List<Competence>competences;
	  @DBRef
	  private List<Notification>notifications;
	  @DBRef
	  private List<RendezVous>rendezVous;
	  
}