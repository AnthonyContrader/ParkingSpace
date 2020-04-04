package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.FloorDTO;
import it.contrader.service.FloorService;
import it.contrader.service.Service;

public class FloorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public FloorServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<FloorDTO> service = new FloorService();
		List<FloorDTO> floorListDTO = service.getAll();
		request.setAttribute("floorlist", floorListDTO);
	}
	
	@Override
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		Service<FloorDTO> service = new FloorService();
		String mode = request.getParameter("mode");
		FloorDTO fDTO;
		boolean ans; //conferma per update , insert, delete
		int id; //lui la dichiara la ma secondo me potrei dichiararle dentro ogni case
		
		switch(mode.toUpperCase()) {
			
		case "FLOORLIST":
			updateList(request); //passo come arg ad updateList la request arrivata da service
			getServletContext().getRequestDispatcher("/floor/floormanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			fDTO = service.read(id);
			request.setAttribute("fDTO", fDTO);
			//questo è cio che fa in user perche ha read e update uniti, ha senso dividerli??
			if (request.getParameter("update")==null) {
				getServletContext().getRequestDispatcher("/floor/floorread.jsp").forward(request, response);
			}
			else {
				getServletContext().getRequestDispatcher("/floor/floorupdate.jsp").forward(request, response);
			}
			break;
			
		case "INSERT":
			Integer number_floor = Integer.parseInt(request.getParameter("number_floor"));
			fDTO = new FloorDTO(number_floor);
			ans = service.insert(fDTO);
			request.setAttribute("ans", ans); //carico la richiesta
			updateList(request);
			getServletContext().getRequestDispatcher("/floor/floormanager.jsp").forward(request, response);
			break;
			
		case "UPDATE": 			
			number_floor = Integer.parseInt(request.getParameter("number_floor"));
			id = Integer.parseInt(request.getParameter("id"));
			//fDTO = new FloorDTO(id , number_floor);
			ans = service.update(new FloorDTO(id , number_floor));
			//request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/floor/floormanager.jsp").forward(request, response);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/floor/floormanager.jsp").forward(request, response);
			break;
			
			
		}
		
	}
	
}












