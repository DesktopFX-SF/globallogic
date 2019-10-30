package com.spring.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.globallogic.model.Person;
import com.spring.globallogic.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@Autowired
	private PersonService 	personService;
	
	@GetMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getAllPersons() {		
		return personService.getAll();
	}
	
	@GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getPerson(@PathVariable Integer id) {
		return personService.getPerson(id);
	}
	

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addPerson(@RequestBody Person person)
	{		
		return personService.addPerson(person);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable Integer id) {		
		return personService.updatePerson(id, person);
	}
	
	@DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> deleteTopic(@PathVariable Integer id) {
		return personService.deletePerson(id);
	}

}
