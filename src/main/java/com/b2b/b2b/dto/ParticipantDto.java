package com.b2b.b2b.dto;

import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.b2b.b2b.menum.TypeEtatCivil;
import com.b2b.b2b.menum.TypeProfil;

import lombok.Data;

@Data
public class ParticipantDto{
	  private String id;
	  private String login;
	  private String password;
	  private TypeProfil profil=TypeProfil.PARTICIPANT;
	  private String nom;
	  private String prenom;
	  private String fonction;
	  private String email;
	  private String telephone;
	  private String telephonePortable;
	  private TypeEtatCivil etatCivil=TypeEtatCivil.M;
	  private boolean activerPlanning;
	  private PaysDto pays;
	  private SocieteDto societe;
	  private List<CompetenceDto>competences;
	  
}