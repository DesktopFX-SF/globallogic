package com.spring.globallogic.repository;



import org.springframework.data.repository.CrudRepository;

import com.spring.globallogic.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	
	Person findById(Integer id);
	Person findByEmail(String email);	
	 void deleteById(Integer id);

}
