package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CarDTO;
import it.contrader.model.Car;



public class CarConverter  implements Converter<Car, CarDTO> {
	
	
	@Override
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = new CarDTO(car.getId(), car.getModel(), car.getLicense());
		return carDTO;
	}

	@Override
	public Car toEntity(CarDTO carDTO) {
		Car car = new Car(carDTO.getId(), carDTO.getModel(), carDTO.getLicense());
		return car;
	}
	
	@Override
	public List<CarDTO> toDTOList(List<Car> carList) {
		//Crea una lista vuota.
		List<CarDTO> carDTOList = new ArrayList<CarDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Car car : carList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			carDTOList.add(toDTO(car));
		}
		return carDTOList;
	}

	
	
}
