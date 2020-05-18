package com.b2b.b2b.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "evenements")
@Data
public class Evenement {
	@Id
	  private String id;
	  private String titre;
	  private String description;
	  private LocalDateTime dateDebut;
	  private LocalDateTime dateFin;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
	  private List<Competence>competences=new ArrayList<>();
	  private List<Participant>participants=new ArrayList<>();
}