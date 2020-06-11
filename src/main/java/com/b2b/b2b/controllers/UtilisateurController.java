package com.b2b.b2b.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2b.b2b.models.Utilisateur;
import com.b2b.b2b.services.UtilisateurService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
@Api(value = "Utilisateur", description = "Permet de gerer les utilisateurs")
public class UtilisateurController {
	
	@Autowired
	UtilisateurService utilisateurService;

	@ApiOperation(value = "Récuperer la liste des utilisateurs", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Utilisateur> getAll() {
		return utilisateurService.findAll();
	  }	
	
	@ApiOperation(value = "Supprimer un utilisateur", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable("id") String id) {
		utilisateurService.deleteById(id);
	  }	
	
}
