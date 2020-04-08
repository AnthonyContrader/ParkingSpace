package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.converter.PersonConverter;
import it.contrader.dao.PersonRepositery;
import it.contrader.dto.PersonDTO;
import it.contrader.model.Person;

@Service
public class PersonService extends AbstractService<Person, PersonDTO>{
	
	private PersonConverter personConverter;
	private PersonRepositery personRepositery;
	
	public PersonDTO findByFirstNameAndSecondName(String firstName, String secondName) {
		return personConverter.toDTO(personRepositery.findByFirstNameAndSecondName(firstName, secondName));
	}
}
