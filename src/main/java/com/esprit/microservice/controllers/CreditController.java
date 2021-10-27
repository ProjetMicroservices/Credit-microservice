package com.esprit.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entities.Credit;
import com.esprit.microservice.services.CreditService;

@RestController
@RequestMapping(value = "/Credit")
public class CreditController {

	@Autowired
	private CreditService CreditService; 
	
	
	
	

	//Configuration de la methode POST
	@PostMapping("/addCredit")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Credit> createCredit(@RequestBody Credit Credit){
		return new ResponseEntity<>(CreditService.addCredit(Credit), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/candidats/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Credit> updateCredit(@PathVariable(value = "id") int id,
			@RequestBody Credit Credit){
		return new ResponseEntity<>(CreditService.updateCredit(id, Credit), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/candidats/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Credit> deleteCredit(@PathVariable(value = "id") int id){
		CreditService.deleteCredit(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/candidats/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Credit> getAllCredits(){
		return CreditService.GetCredit();
	}
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode de recherche GET specifique avec PathParam
	//il faut que les noms des methodes ici Candidat Resst API) et celles dans CandidatService n'aient pas le meme nom, sinon ca degere une erreue de mapping
	//Execution URL: http://localhost:8282/api/candidats
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Credit> searchCredit(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(CreditService.findCredit(id), HttpStatus.OK);
	}
	
}
