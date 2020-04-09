package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Car;

@Repository
@Transactional

public interface CarRepository extends JpaRepository <Car, String>{
	
	 //Car findByLicenseAndModel (String license, String model);
     Car findByLicense(String license);
}
