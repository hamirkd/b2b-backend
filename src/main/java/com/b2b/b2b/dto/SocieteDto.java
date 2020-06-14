package com.b2b.b2b.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SocieteDto {
	  private String id;
	  private String nom;
	  private Double capital;
	  private Double chiffreAffaire;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}