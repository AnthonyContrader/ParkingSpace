package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Parkingplace;

@Repository
@Transactional
public interface  ParkingplaceRepository extends CrudRepository<Parkingplace, Long> {

	Parkingplace findByNumberplace(int numberplace);
}
