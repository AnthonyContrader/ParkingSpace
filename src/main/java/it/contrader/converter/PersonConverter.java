package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PersonDTO;
import it.contrader.model.Person;

@Component
public class PersonConverter extends AbstractConverter<Person, PersonDTO>{

	@Override
	public Person toEntity(PersonDTO personDDTO) {
		Person person = null;
		if(personDDTO!=null) {
		    person = new Person (personDDTO.getId(), personDDTO.getFirstName(),personDDTO.getSecondName());
		}
		return person;
	}

	@Override
	public PersonDTO toDTO(Person person) {
	    PersonDTO personDTO = null;
	    if(person!=null) {
		    personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getSecondName());
	    }
	    return personDTO;
	}


}

