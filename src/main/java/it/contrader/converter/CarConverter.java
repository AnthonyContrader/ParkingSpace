package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

@Component
public class CarConverter extends AbstractConverter <Car, CarDTO>{
	
	@Override
	public Car toEntity(CarDTO carDTO) {
		Car car = null;
		if (carDTO != null) {
			car = new Car(carDTO.getLicense(),carDTO.getModel());			
		}
		
		return car;
	}
	
	@Override
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = null;
		if (car != null) {
			carDTO = new CarDTO(car.getLicense(), car.getModel());
			
		}
		return carDTO;
	}
	

}
