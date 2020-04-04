package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.model.AssignmentParking;

public class AssignmentParkingConverter implements Converter<AssignmentParking, AssignmentParkingDTO> {
        public AssignmentParkingDTO toDTO(AssignmentParking aParking) {
            AssignmentParkingDTO assignmentParkingDTO = new AssignmentParkingDTO(aParking.getId(), aParking.getIdCar(), aParking.getIdPostiAuto());
            assignmentParkingDTO.setEntryDate(aParking.getEntryDate());
            assignmentParkingDTO.setEntryTime(aParking.getEntryTime());
            return assignmentParkingDTO;
        }

        public AssignmentParking toEntity(AssignmentParkingDTO apd) {
            AssignmentParking aParking = new AssignmentParking(apd.getId(), apd.getIdCar(), apd.getIdPostiAuto());
            aParking.setEntryDate(apd.getEntryDate());
            aParking.setEntryTime(apd.getEntryTime());
            return aParking;
        }

        /**
         * Metodo per convertire le liste di AssignmentParking in liste di AssignmentParkingDTO
         */
        @Override
        public List<AssignmentParkingDTO> toDTOList(List<AssignmentParking> assignmentParkingList){

            List<AssignmentParkingDTO> list = new ArrayList<AssignmentParkingDTO>();
            for(AssignmentParking ap: assignmentParkingList) {
                list.add(toDTO(ap));

            }
            return list;
        }

}
