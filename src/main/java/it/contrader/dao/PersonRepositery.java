package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Person;

public interface PersonRepositery extends CrudRepository<Person, Long>{
	Person findByFirstNameAndSecondName(String firstName, String secondName);
}
