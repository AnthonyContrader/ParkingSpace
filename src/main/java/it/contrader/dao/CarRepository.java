package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Car;


@Repository
@Transactional


public interface CarRepository extends JpaRepository<Car, String>{

	Car findByLicense(String license);
    List<Car> findCarsByModel(String model);
	
}