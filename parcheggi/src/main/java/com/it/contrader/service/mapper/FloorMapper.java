package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.FloorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Floor and its DTO FloorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FloorMapper extends EntityMapper<FloorDTO, Floor> {



    default Floor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Floor floor = new Floor();
        floor.setId(id);
        return floor;
    }
}
