package it.contrader.com.service.mapper;

import it.contrader.com.domain.*;
import it.contrader.com.service.dto.BillDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Bill and its DTO BillDTO.
 */
@Mapper(componentModel = "spring", uses = {AssignmentParkingMapper.class})
public interface BillMapper extends EntityMapper<BillDTO, Bill> {

    @Mapping(source = "assignment.id", target = "assignmentId")
    BillDTO toDto(Bill bill);

    @Mapping(source = "assignmentId", target = "assignment")
    Bill toEntity(BillDTO billDTO);

    default Bill fromId(Long id) {
        if (id == null) {
            return null;
        }
        Bill bill = new Bill();
        bill.setId(id);
        return bill;
    }
}
