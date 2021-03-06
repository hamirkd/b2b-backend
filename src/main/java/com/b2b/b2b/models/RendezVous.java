package com.b2b.b2b.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "rendezvous")
@Data
public class RendezVous {
	@Id
	  private String id;
	  private String numeroTable;
	  private int duree;//en minute
	  private LocalDateTime dateDebut;
	  private LocalDateTime dateFin;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
	  @DBRef
	  @Indexed(unique=false)
	  private Participant participant1;
	  @DBRef
	  @Indexed(unique=false)
	  private Participant participant2;
	  @DBRef
	  private Evenement Evenement;
	  private Boolean annuler;
	  
}