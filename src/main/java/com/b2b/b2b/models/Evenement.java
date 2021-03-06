package com.b2b.b2b.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.b2b.b2b.menum.TypeNombreParticipant;

import lombok.Data;

@Document(collection = "evenements")
@Data
public class Evenement {
	@Id
	  private String id;
	  private String titre;
	  private String description;
	  private TypeNombreParticipant nombreParticipant=TypeNombreParticipant.ILIMITE;
	  private int nombre;
	  private LocalDateTime dateDebut;
	  private LocalDateTime dateFin;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
	  @DBRef
	  private List<Competence>competences=new ArrayList<>();
	  @DBRef
	  private List<Langue>langues=new ArrayList<>();
	  @DBRef
	  @Indexed(unique=false)
	  private List<Participant>participants;
}