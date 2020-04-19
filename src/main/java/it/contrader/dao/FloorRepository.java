package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Floor;

@Repository
@Transactional
public interface FloorRepository extends CrudRepository <Floor , Long> {
	
	Floor findByNumberfloor(int numberfloor);
}
