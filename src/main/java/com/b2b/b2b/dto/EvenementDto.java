package com.b2b.b2b.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.b2b.b2b.models.Participant;

import lombok.Data;

@Data
public class EvenementDto {
	  private String id;
	  private String login;
}