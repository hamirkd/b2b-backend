package com.b2b.b2b.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2b.b2b.models.Langue;
import com.b2b.b2b.services.LangueService;

@CrossOrigin("*")
@RestController
@RequestMapping("/langue")
public class LangueController {
	
	@Autowired
	LangueService langueService;
	
	@GetMapping("/")
	  public List<Langue> getAllLangue() {
		return langueService.findAllLangue();
	  }	
}
