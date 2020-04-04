package it.contrader.service;

import it.contrader.converter.AssignmentParkingConverter;
import it.contrader.dao.AssignmentParkingDAO;
import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.model.AssignmentParking;

public class AssignmentParkingService extends AbstractService<AssignmentParking, AssignmentParkingDTO>{

        public AssignmentParkingService() {
            this.dao = new AssignmentParkingDAO();
            this.converter = new AssignmentParkingConverter();
        }
}
