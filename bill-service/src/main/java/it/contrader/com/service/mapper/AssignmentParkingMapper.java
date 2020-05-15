package it.contrader.com.service.mapper;

import it.contrader.com.domain.*;
import it.contrader.com.service.dto.AssignmentParkingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AssignmentParking and its DTO AssignmentParkingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AssignmentParkingMapper extends EntityMapper<AssignmentParkingDTO, AssignmentParking> {



    default AssignmentParking fromId(Long id) {
        if (id == null) {
            return null;
        }
        AssignmentParking assignmentParking = new AssignmentParking();
        assignmentParking.setId(id);
        return assignmentParking;
    }
}
