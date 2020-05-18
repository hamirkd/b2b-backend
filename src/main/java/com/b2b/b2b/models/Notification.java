package com.b2b.b2b.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.b2b.b2b.menum.TypeCible;

import lombok.Data;

@Document(collection = "notifications")
@Data
public class Notification {
	@Id
	  private String id;
	  private String contenu;
	  private TypeCible cible;
	  private List<Competence>competence;
	  @DBRef
	  private List<Participant>participant;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}