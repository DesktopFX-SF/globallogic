package com.spring.globallogic.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.globallogic.model.Person;
import com.spring.globallogic.process.ProcessValid;
import com.spring.globallogic.repository.PersonRepository;
import com.spring.globallogic.result.PersonRes;
import com.spring.globallogic.result.Result;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository; 
	Result result = new Result();
	
	
	public ResponseEntity<?> getAll()
	{
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(persons::add);
		if (persons.isEmpty()) {
			result.setMessage("No hay resultados disponibles");
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getPerson(Integer id) {
		Person person = personRepository.findById(id);
		if (person == null) {
			result.setMessage("No hay resultados disponibles: " + id.toString());
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	
	public Person getPersonEmail(String email) {
		return personRepository.findByEmail(email);		
		//return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	public ResponseEntity<?> addPerson(Person person) {	
		ProcessValid validate = new ProcessValid(); 
		result = validate.validateObject(person);
		if(result.getStatus()== false) {			
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		
		validateEmail(person.getEmail(), person.getId());				
		if(result.getStatus()== false) {			
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		
		person.setToken(UUID.randomUUID());
		person.setCreated(new Date());
		person.setIsactive(true);
		person.setLast_login(new Date());
	
		personRepository.save(person);
		
		PersonRes personres = new PersonRes();
		personres.setCreated(person.getCreated());
		personres.setId(person.getId());
		personres.setIsactive(person.getIsactive());
		personres.setLast_login(person.getLast_login());
		personres.setModified(person.getModified());
		personres.setToken(person.getToken());
		
		return new ResponseEntity<PersonRes>(personres, HttpStatus.OK);
	}
	
	public ResponseEntity<?> updatePerson(Integer id, Person person) {
		ProcessValid validate = new ProcessValid();		
		result = validate.validateObject(person);	
		
		if(result.getStatus()== false) {			
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		
		validateEmail(person.getEmail(), person.getId());				
		if(result.getStatus()== false) {			
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}		
		
		person.setModified(new Date());
		
		Person personBefore = personRepository.findById(person.getId());
		if (personBefore == null) {
			result.setMessage("id no existe.");
			result.setStatus(false);
			result.setStatusCode(HttpStatus.OK);
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		person.setCreated(personBefore.getCreated());
		person.setIsactive(personBefore.getIsactive());
		person.setLast_login(personBefore.getLast_login());
		person.setToken(personBefore.getToken());		
		
		personRepository.save(person);
		
		PersonRes personres = new PersonRes();		
		personres.setCreated(person.getCreated());
		personres.setId(person.getId());
		personres.setIsactive(person.getIsactive());
		personres.setLast_login(person.getLast_login());
		personres.setModified(person.getModified());
		personres.setToken(person.getToken());
		return new ResponseEntity<PersonRes>(personres, HttpStatus.OK);
	}
	
	public ResponseEntity<?> deletePerson(Integer id) {	
		
		Person person = personRepository.findById(id);
		if (person == null) {
			result.setMessage("id no existe.");
			result.setStatus(false);
			result.setStatusCode(HttpStatus.OK);
			return new ResponseEntity<Result>(result, result.getStatusCode());
		}
		personRepository.delete(person);
		result.setMessage("Borrado con exito: " + id.toString());
		result.setStatus(true);
		result.setStatusCode(HttpStatus.OK);
		return new ResponseEntity<Result>(result, result.getStatusCode());
	}
	
	private void validateEmail(String email, Integer vId) {
		/*
		 * vId
		 * 1 : register.
		 * 2 : update.
		 */
		String 	message = "";
		boolean vBand 	= true;
		Person validateEmail = getPersonEmail(email);
		if(validateEmail != null) {	
			message = "El correo ya esta registrado.";
			vBand = false;	
			if (validateEmail.getId() == vId) {
				message = "";
				vBand = true;
			}
					
		}		
		result.setMessage(message);
		result.setStatus(vBand);				
	}
	
	
	

}
