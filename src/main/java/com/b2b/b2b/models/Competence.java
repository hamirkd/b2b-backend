package com.b2b.b2b.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "competences")
@Data
public class Competence {
	@Id
	  private String id;
	  private String nom;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}