package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CarDTO;
import it.contrader.service.Service;
import it.contrader.service.CarService;

public class CarServlet extends HttpServlet{
	
	// identificativo protocollo http codice identificativo unico
	
	private static final long serialVersionUID = 1L;
	
	public CarServlet () {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CarDTO> service = new CarService();
		List<CarDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CarDTO> service = new CarService();
		String mode = request.getParameter("mode");
		CarDTO dto;
		
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {
		
		case "CARLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;

		case "READ":
			System.out.println("sono al read di servlet");
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/car/readcar.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/car/updatecar.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String model = request.getParameter("model").toString();
			String license = request.getParameter("license").toString();
			dto = new CarDTO (model,license);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			model = request.getParameter("model");
			license = request.getParameter("license");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CarDTO (id,model, license);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;
		}
		
		
		}

	
	

}
