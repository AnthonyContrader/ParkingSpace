package com.it.laura.service.mapper;

import com.it.laura.domain.*;
import com.it.laura.service.dto.CarDTO;

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
