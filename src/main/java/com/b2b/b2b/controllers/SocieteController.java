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

import com.b2b.b2b.models.Societe;
import com.b2b.b2b.services.SocieteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/societe")
@Api(value = "Societe", description = "Permet de gerer les societes")
public class SocieteController {
	
	@Autowired
	SocieteService societeService;

	@ApiOperation(value = "Récuperer la liste des societes", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Societe> getAll() {
		return societeService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter une societe", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Societe add(@Valid @RequestBody Societe societe) {
		return societeService.add(societe);
	  }	

	@ApiOperation(value = "Modifier une societe", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Societe update(@Valid @RequestBody Societe societe) {
		return societeService.update(societe);
	  }	

	@ApiOperation(value = "Supprimer une societe", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/")
	  public void delete(@Valid @RequestBody String id) {
		societeService.deleteById(id);
	  }	
	
}
