package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

@Repository
@Transactional  //ha i permessi per transazioni su DB
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

}

//spring boot evita sbatti in configurazione spring---> boot crea application context : pattern IoC == dichiari un istanza DI ci pensa lui per le successive
//ioc container in cui specifichi caratteristiche e dipendenze oggetti , repository estende crud al fagiolone user e alll'identita di qst ID

