package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	public enum Usertype {
		ADMIN, USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true) //username dev'essere diverso
	private String username;

	private String password;

	private Usertype usertype;   //usertype dichiarato alla riga 19
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="id_person", referencedColumnName="id") private Person
	 * person;
	 */

}
