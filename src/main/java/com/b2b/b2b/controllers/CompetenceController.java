package com.b2b.b2b.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2b.b2b.models.Competence;
import com.b2b.b2b.services.CompetenceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/competence")
@Api(value = "Competence", description = "Permet de gerer les competences")
public class CompetenceController {
	
	@Autowired
	CompetenceService competenceService;

	@ApiOperation(value = "Récuperer la liste des competences", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Competence> getAll() {
		return competenceService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter une competence", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Competence add(@Valid @RequestBody Competence competence) {
		return competenceService.add(competence);
	  }	

	@ApiOperation(value = "Modifier une competence", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Competence update(@Valid @RequestBody Competence competence) {
		return competenceService.update(competence);
	  }	

	@ApiOperation(value = "Supprimer une competence", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/")
	  public void delete(@Valid @RequestBody String id) {
		competenceService.deleteById(id);
	  }	
	
}
