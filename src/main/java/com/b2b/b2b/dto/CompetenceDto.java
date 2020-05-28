package com.b2b.b2b.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class CompetenceDto {
	  private String id;
	  private String nom;
	  private LocalDateTime dateCreation;
	  private LocalDateTime dateModification;
}