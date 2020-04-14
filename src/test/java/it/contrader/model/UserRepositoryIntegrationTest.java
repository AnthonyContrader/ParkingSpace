package it.contrader.model;


import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import it.contrader.dao.UserRepository;
import it.contrader.model.User.Usertype;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
	
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserRepository userRepository;
	
	
	//write test cases here
	
	
	@Test
	public void whenFindByUsernameAndPassword_thenReturnUser() {
		User u = new User();
		u.setUsername("user");
		u.setPassword("pass");
		u.setUsertype(Usertype.USER);
		entityManager.persist(u);
		entityManager.flush();
		
		User found = userRepository.findByUsernameAndPassword(u.getUsername(),u.getPassword());
		
		//Assert.assertTrue(found.getUsername().equals(u.getUsername()));
		//Assert.assertTrue(1==2);
		Assert.assertTrue(found.equals(u));
	}
}
;