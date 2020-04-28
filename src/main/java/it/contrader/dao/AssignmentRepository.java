package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.AssignmentParking;
import it.contrader.model.Car;
import it.contrader.model.Parkingplace;

@Repository
@Transactional
public interface AssignmentRepository extends CrudRepository<AssignmentParking, Long>{
	AssignmentParking findByCarAndParkingplace(Car car, Parkingplace parkingplace);
}

