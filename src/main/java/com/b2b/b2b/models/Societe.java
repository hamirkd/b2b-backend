package com.b2b.b2b.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "societes")
@Data
public class Societe {
	@Id
	  private String id;
	  private String nom;
	  private Double capital;
	  private Double chiffreAffaire;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}