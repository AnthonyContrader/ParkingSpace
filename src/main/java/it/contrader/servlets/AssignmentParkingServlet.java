package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.dto.CarDTO;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.service.AssignmentParkingService;
import it.contrader.service.CarService;
import it.contrader.service.ParkingplaceService;
import it.contrader.service.Service;

public class AssignmentParkingServlet extends HttpServlet{

        private static final long serialVersionUID = 1L;


        public AssignmentParkingServlet() {

        }

        public void updateList(HttpServletRequest request) {
        	//provo a creare un service Car e un parkingplace
            Service<AssignmentParkingDTO> service    = new AssignmentParkingService();
            Service<CarDTO> service1 = new CarService();
            List<CarDTO> carList     = service1.getAll();
            List<AssignmentParkingDTO>    listDTO    = service.getAll();
            Service<ParkingplaceDTO> service2 = new ParkingplaceService();
            List<ParkingplaceDTO> pList     = service2.getAll();
            request.setAttribute("list", listDTO);
            request.setAttribute("listcar", carList);
            request.setAttribute("listparking", pList);
        }
        @Override
        public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                Service<AssignmentParkingDTO> service = new AssignmentParkingService();
                String mode = request.getParameter("mode");
                AssignmentParkingDTO assignmentParkingDTO;
                int id;
                boolean answer;

                switch(mode.toUpperCase()) {
                case "ASSIGNMENTPARKINGLIST":
                    updateList(request);
                    getServletContext().getRequestDispatcher("/assignmentParking/assignmentmanager.jsp").forward(request, response);;
                    break;
                case "READ":
                    id = Integer.parseInt(request.getParameter("id"));
                    assignmentParkingDTO = service.read(id);
                    request.setAttribute("assignmentParkingDTO", assignmentParkingDTO);

                    if(request.getParameter("update") == null) {
                        getServletContext().getRequestDispatcher("/assignmentParking/readassignment.jsp").forward(request, response);
                    }else{
                        getServletContext().getRequestDispatcher("/assignmentParking/updateassignment.jsp").forward(request, response);
                    }break;
                case "INSERT":
                    //id = Integer.parseInt(request.getParameter("id"));
                    int idCar = Integer.parseInt(request.getParameter("idCar"));
                    int idPostoAuto = Integer.parseInt(request.getParameter("idPostoAuto"));
                    assignmentParkingDTO = new AssignmentParkingDTO(idCar, idPostoAuto);
                    answer = service.insert(assignmentParkingDTO);
                    request.setAttribute("answer", answer);
                    updateList(request);
                    getServletContext().getRequestDispatcher("/assignmentParking/assignmentmanager.jsp").forward(request, response);
                    break;

                case "UPDATE":
                    id = Integer.parseInt(request.getParameter("id"));
                    System.out.println("Case Update Servlet prima di id_car");
                    idCar = Integer.parseInt(request.getParameter("id_car"));
                    idPostoAuto = Integer.parseInt(request.getParameter("idPostoAuto"));
                    assignmentParkingDTO = new AssignmentParkingDTO(id, idCar, idPostoAuto);
                    answer = service.update(assignmentParkingDTO);
                    updateList(request);
                    getServletContext().getRequestDispatcher("/assignmentParking/assignmentmanager.jsp").forward(request, response);
                    break;


                case "DELETE":
                    id = Integer.parseInt(request.getParameter("id"));
                    answer = service.delete(id);
                    request.setAttribute("answer", answer);
                    updateList(request);
                    getServletContext().getRequestDispatcher("/assignmentParking/assignmentmanager.jsp").forward(request, response);
                    break;
                }


        }
}
