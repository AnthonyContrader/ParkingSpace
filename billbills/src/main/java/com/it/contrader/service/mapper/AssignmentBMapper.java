package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.AssignmentBDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AssignmentB and its DTO AssignmentBDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AssignmentBMapper extends EntityMapper<AssignmentBDTO, AssignmentB> {



    default AssignmentB fromId(Long id) {
        if (id == null) {
            return null;
        }
        AssignmentB assignmentB = new AssignmentB();
        assignmentB.setId(id);
        return assignmentB;
    }
}
