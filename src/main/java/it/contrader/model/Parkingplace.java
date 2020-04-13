package it.contrader.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"numberplace", "id_floor"}))
public class Parkingplace {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
	//@Column(unique = true) due numberplace con lo stesso valore, si distinguono da id e id_floor.
	private int numberplace;
	
	//non deve essere nullo perche non ha senso di esistere un PostoAuto senza un Piano.
	@ManyToOne
	@JoinColumn(name ="id_floor", nullable=false,referencedColumnName="id")
	private Floor floor; 
	
	

}

