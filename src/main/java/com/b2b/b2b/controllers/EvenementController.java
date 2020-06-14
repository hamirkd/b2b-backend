package com.b2b.b2b.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2b.b2b.dto.EvenementDto;
import com.b2b.b2b.models.Evenement;
import com.b2b.b2b.services.EvenementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/evenement")
@Api(value = "Evenement", description = "Permet de gerer les evenements")
public class EvenementController {
	
	@Autowired
	EvenementService evenementService;

	@ApiOperation(value = "Récuperer la liste des evenements", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Evenement> getAll() {
		return evenementService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter un evenement", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Evenement add(@Valid @RequestBody Evenement evenement) {
		return evenementService.add(evenement);
	  }	
	
	@ApiOperation(value = "Ajouter ou supprimer un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/addp")
	  public Evenement addOrDeleteParticipant(@Valid @RequestBody EvenementDto evenement) {
		return evenementService.addOrDeleteParticipant(evenement.getId(), evenement.getLogin());
	  }	

	@ApiOperation(value = "Modifier un evenement", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Evenement update(@Valid @RequestBody Evenement evenement) {
		return evenementService.update(evenement);
	  }	

	@ApiOperation(value = "Supprimer un evenement", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable("id") String id) {
		evenementService.deleteById(id);
	  }	
	


	@ApiOperation(value = "Récuperer la liste des evenements à la quelle participe un utilisateur", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/findByParticipant/{participantId}")
	  public List<Evenement> findEvenementByParticipant(@PathVariable("participantId") String participantId) {
		return evenementService.findEvenementByParticipant(participantId);
	  }	
	
}
