package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.ParkingPlaceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ParkingPlace and its DTO ParkingPlaceDTO.
 */
@Mapper(componentModel = "spring", uses = {FloorMapper.class})
public interface ParkingPlaceMapper extends EntityMapper<ParkingPlaceDTO, ParkingPlace> {

    @Mapping(source = "floor.id", target = "floorId")
    ParkingPlaceDTO toDto(ParkingPlace parkingPlace);

    @Mapping(source = "floorId", target = "floor")
    ParkingPlace toEntity(ParkingPlaceDTO parkingPlaceDTO);

    default ParkingPlace fromId(Long id) {
        if (id == null) {
            return null;
        }
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.setId(id);
        return parkingPlace;
    }
}
