package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User, UserDTO> {

	@Autowired   //sfruttando le reflections costruisce tutto lui == fa il costruttore e crea le dipendenze
	private UserConverter converter;
	@Autowired
	private UserRepository repository;

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	}

}


//reflections permette di creare metodi in tempo di runtime
