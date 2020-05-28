package com.b2b.b2b.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaysDto {
	  private String id;
	  private String nom;
	  private String code;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}