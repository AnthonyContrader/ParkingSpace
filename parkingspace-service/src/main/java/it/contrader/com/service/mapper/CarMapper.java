package it.contrader.com.service.mapper;

import it.contrader.com.domain.*;
import it.contrader.com.service.dto.CarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Car and its DTO CarDTO.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface CarMapper extends EntityMapper<CarDTO, Car> {

    @Mapping(source = "person.id", target = "personId")
    CarDTO toDto(Car car);

    @Mapping(source = "personId", target = "person")
    Car toEntity(CarDTO carDTO);

    default Car fromId(Long id) {
        if (id == null) {
            return null;
        }
        Car car = new Car();
        car.setId(id);
        return car;
    }
}
