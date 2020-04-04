package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.service.ParkingplaceService;
import it.contrader.service.Service;
//HttpServlet è una classe base da estendere per creare un servlet HTTP adatto a gestire richieste HTTP e fornire risposte. Di solito sovrascriviamo metodi come doGet (..), doPost (..) ecc.
public class ParkingplaceServlet extends HttpServlet {
	//SerialVersionUID è un identificatore di versione universale per una classe serializzabile. La deserializzazione utilizza questo numero per garantire che una classe caricata corrisponda esattamente a un oggetto serializzato. Se non viene trovata alcuna corrispondenza, viene generata una InvalidClassException.
	private static final long serialVersionUID = 1L;
	
	public ParkingplaceServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ParkingplaceDTO> service = new ParkingplaceService();
		List<ParkingplaceDTO>listDTO = service.getAll();
		//memorizza un attributo in questa richiesta. gli attributi vengono reimpostati tra le richieste.
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ParkingplaceDTO> service = new ParkingplaceService();
		//Restituisce il valore di un parametro di richiesta come String o null se il parametro non esiste.
		String mode = request.getParameter("mode");
		ParkingplaceDTO dto;
		int id;
		boolean ans;
		
		switch(mode.toUpperCase()) {
		
		case "PARKINGPLACELIST":
			updateList(request);
			//Ottiene il contesto servlet in cui è stata inviata l'ultima ServletRequest.
			//Restituisce un oggetto RequestDispatcher che funge da wrapper per la risorsa situata nel percorso specificato.
			//inoltra la richiesta tramite forward 
			getServletContext().getRequestDispatcher("/parkingplace/parkingplacemanager.jsp").forward(request,response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/parkingplace/readparkingplace.jsp").forward(request, response);
						}
			
			else getServletContext().getRequestDispatcher("/parkingplace/updateparkingplace.jsp").forward(request, response);
			break;
			
		case "INSERT":
		     int numberplace = Integer.parseInt(request.getParameter("numberplace"));
			dto = new ParkingplaceDTO (numberplace);
			ans = service.insert(dto);
			request.setAttribute("ans",ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/parkingplace/parkingplacemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			numberplace = Integer.parseInt(request.getParameter("numberplace"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ParkingplaceDTO (id,numberplace);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/parkingplace/parkingplacemanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans",ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/parkingplace/parkingplacemanager.jsp").forward(request, response);
			break;
			}
			
		}
		
	}

