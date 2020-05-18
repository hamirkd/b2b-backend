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

import com.b2b.b2b.models.Notification;
import com.b2b.b2b.services.NotificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/notification")
@Api(value = "Notification", description = "Permet de gerer les notifications")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;

	@ApiOperation(value = "Récuperer la liste des notifications", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Items getted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@GetMapping("/")
	  public List<Notification> getAll() {
		return notificationService.findAll();
	  }	
	

	@ApiOperation(value = "Ajouter un notification", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item added"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PostMapping("/")
	  public Notification add(@Valid @RequestBody Notification notification) {
		return notificationService.add(notification);
	  }	

	@ApiOperation(value = "Modifier un notification", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item updated"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@PutMapping("/")
	  public Notification update(@Valid @RequestBody Notification notification) {
		return notificationService.update(notification);
	  }	

	@ApiOperation(value = "Supprimer un notification", notes = "", tags = { "", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Item deleted"),
			@ApiResponse(code = 400, message = "Bad Request"),
	})
	@DeleteMapping("/")
	  public void delete(@Valid @RequestBody String id) {
		notificationService.deleteById(id);
	  }	
	
}
