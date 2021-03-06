package com.b2b.b2b.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.b2b.b2b.menum.TypeProfil;

import lombok.Data;

@Document(collection = "utilisateurs")
@Data
public class Utilisateur {
	@Id
	  private String id;
	  private String login;
	  private String email;
	  private String password;
	  private TypeProfil profil;
	  private String nom;
	@CreatedDate
	  private LocalDateTime dateCreation=LocalDateTime.now();
	  private LocalDateTime dateModification=LocalDateTime.now();
	  private boolean status=false;
}