package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Person;
@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long>{
	Person findByFirstNameAndSecondName(String firstName, String secondName);
}
