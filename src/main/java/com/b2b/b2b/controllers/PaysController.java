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

import com.b2b.b2b.models.Pays;
import com.b2b.b2b.services.PaysService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
@Api(value = "Pays", description = "Permet de gerer les payss")
public class PaysController {
	
	@Autowired
	PaysService paysService;

	@ApiOperation(value = "Récuperer la liste des payss", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Pays> getAll() {
		return paysService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter un pays", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Pays add(@Valid @RequestBody Pays pays) {
		return paysService.add(pays);
	  }	

	@ApiOperation(value = "Modifier un pays", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Pays update(@Valid @RequestBody Pays pays) {
		return paysService.update(pays);
	  }	

	@ApiOperation(value = "Supprimer un pays", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/")
	  public void delete(@Valid @RequestBody String id) {
		paysService.deleteById(id);
	  }	
	
}
