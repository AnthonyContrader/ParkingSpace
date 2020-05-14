package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.AssigmentParkingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AssigmentParking and its DTO AssigmentParkingDTO.
 */
@Mapper(componentModel = "spring", uses = {CarMapper.class, ParkingPlaceMapper.class})
public interface AssigmentParkingMapper extends EntityMapper<AssigmentParkingDTO, AssigmentParking> {

    @Mapping(source = "car.id", target = "carId")
    @Mapping(source = "parkingplace.id", target = "parkingplaceId")
    AssigmentParkingDTO toDto(AssigmentParking assigmentParking);

    @Mapping(source = "carId", target = "car")
    @Mapping(source = "parkingplaceId", target = "parkingplace")
    AssigmentParking toEntity(AssigmentParkingDTO assigmentParkingDTO);

    default AssigmentParking fromId(Long id) {
        if (id == null) {
            return null;
        }
        AssigmentParking assigmentParking = new AssigmentParking();
        assigmentParking.setId(id);
        return assigmentParking;
    }
}
