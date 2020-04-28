package it.contrader.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name="Assignment")
public class AssignmentParking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@JoinColumn(name="car_license", referencedColumnName="license")
	@OneToOne
	private Car car;
	@OneToOne
	@JoinColumn(name="id_parkingplace", referencedColumnName="id")
	private Parkingplace parkingplace;
	
	
	  @Temporal(TemporalType.DATE)
	  @Column(name="entryDate") 
	  private Date entryDate;
	  @Temporal(TemporalType.TIME)
	  @Column(name="entryTime")
	  private Date entryTime;
	
	
}
