package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.AssignmentParkingConverter;
import it.contrader.dao.AssignemntRepository;
import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.model.AssignmentParking;
import it.contrader.model.Car;
import it.contrader.model.Parkingplace;
@Service
public class AssignmentParkingService extends AbstractService<AssignmentParking, AssignmentParkingDTO>{
	
	@Autowired
	private AssignemntRepository repository;
	@Autowired
	private AssignmentParkingConverter converter;
	
	public AssignmentParkingDTO findByCarAndParkingplace(Car car, Parkingplace pp) {
		return converter.toDTO(repository.findByCarAndParkingplace(car, pp));
	}
}
