package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.AssignmentParking;
import it.contrader.model.Car;
import it.contrader.model.Parkingplace;

public interface AssignemntRepository extends CrudRepository<AssignmentParking, Long>{
	AssignmentParking findByCarAndParkingplace(Car car, Parkingplace parkingplace);
}
