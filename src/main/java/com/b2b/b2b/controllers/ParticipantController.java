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

import com.b2b.b2b.models.Participant;
import com.b2b.b2b.models.Utilisateur;
import com.b2b.b2b.services.ParticipantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
@Api(value = "Participant", description = "Permet de gerer les participants")
public class ParticipantController {
	
	@Autowired
	ParticipantService participantService;

	@ApiOperation(value = "Récuperer la liste des participants", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Participant> getAll() {
		return participantService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Participant add(@Valid @RequestBody Participant participant) {
		return participantService.add(participant);
	  }	

	@ApiOperation(value = "Connexion un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/login")
	  public Utilisateur login(@Valid @RequestBody Participant participant) throws Exception {
		Utilisateur utilisateur=participantService.login(participant);
		return utilisateur;
	  }	

	@ApiOperation(value = "Connexion un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/bylogin")
	  public Participant findByLogin(@Valid @RequestBody Participant participant) {
		Participant utilisateur=participantService.findByLogin(participant);
		return utilisateur;
	  }	
	@ApiOperation(value = "Modifier un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Utilisateur update(@Valid @RequestBody Participant participant) {
		return participantService.update(participant);
	  }	

	@ApiOperation(value = "Supprimer un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable("id") String id) {
		participantService.deleteById(id);
	  }	

	@ApiOperation(value = "Récupérer un participant", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/{id}")
	  public Participant getById(@PathVariable("id") String id) throws Exception {
		return participantService.findById(id);
	  }	
	
}
