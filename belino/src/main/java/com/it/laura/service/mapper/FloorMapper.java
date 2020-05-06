package com.it.laura.service.mapper;

import com.it.laura.domain.*;
import com.it.laura.service.dto.FloorDTO;

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
