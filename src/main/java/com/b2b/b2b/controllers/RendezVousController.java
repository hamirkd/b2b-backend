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

import com.b2b.b2b.models.RendezVous;
import com.b2b.b2b.services.RendezVousService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/rendez-vous")
@Api(value = "RendezVous", description = "Permet de gerer les rendez-vouss")
public class RendezVousController {
	
	@Autowired
	RendezVousService rendezVousService;

	@ApiOperation(value = "Récuperer la liste des rendez-vouss", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<RendezVous> getAll() {
		return rendezVousService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter une rendez-vous", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public RendezVous add(@Valid @RequestBody RendezVous rendezVous) {
		return rendezVousService.add(rendezVous);
	  }	

	@ApiOperation(value = "Modifier une rendez-vous", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public RendezVous update(@Valid @RequestBody RendezVous rendezVous) {
		return rendezVousService.update(rendezVous);
	  }	

	@ApiOperation(value = "Supprimer une rendez-vous", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable("id") String id) {
		rendezVousService.deleteById(id);
	  }	
	

	@ApiOperation(value = "Ajouter les rendez-vous générer dans un évènement", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/genererList")
	  public List<RendezVous> addListGenerationRendezVous(@Valid @RequestBody List<RendezVous> rendezVous) {
		return rendezVousService.sauvegarderGeneration(rendezVous);
	  }


	@ApiOperation(value = "Récuperer la liste des rendez-vouss", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/findByEvenement/{evenementId}")
	  public List<RendezVous> findByEvenement(@PathVariable("evenementId") String evenementId) {
		return rendezVousService.findByEvenement(evenementId);
	  }	


	@ApiOperation(value = "Récuperer la liste des rendez-vouss", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/findByParticipant/{login}")
	  public List<RendezVous> findByParticipant(@PathVariable("login") String login) {
		return rendezVousService.findByParticipant(login);
	  }	
	
}
