package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Person;

public interface PersonRepositery extends CrudRepository<Person, Long>{
	Person findByFirstNameAndSecondName(String firstName, String secondName);
}
