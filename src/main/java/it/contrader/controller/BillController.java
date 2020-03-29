package it.contrader.controller;

/**
 * @author comelli_laura
*/

import java.util.List;

import it.contrader.dto.BillDTO;
import it.contrader.main.MainDispatcher;

/**
 * @author comelli_laura
*/

import it.contrader.service.BillService;

public class BillController implements Controller {

	private static String sub_package = "bill.";   //considering all the package bill.
	
	private BillService billService;    //creating a Service 
	
	public BillController(){
		
		//instantiated the object BillService to use its methods
		this.billService = new BillService();
	}
	
	@Override
		//void because this methods does not return anything But links to the CRUD selected page to insert parameters or calls the Service
			//a mio modesto parere ma non so un cazzo passa comunque dai Service
	
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");  //"mode" è la key=string in request definita in submit in quella che sarà BillView
		String choice = (String) request.get("choice");   //"choice" è la key=string in request definita in submit in quella che sarà BillView
		
		//define Bill fields
		
		int id;
		int id_assignment;
		double price;
		boolean is_paid;
		
		switch(mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			BillDTO billDTO = billService.read(id);  //creating an DTO object where i m going to save the result of read method
			request.put("bill", billDTO);
			MainDispatcher.getInstance().callView(sub_package + "BillRead" , request);
			break;
			
		case "INSERT":
			id_assignment = Integer.parseInt(request.get("id_assignment").toString());
			price = Double.parseDouble(request.get("price").toString());
			is_paid = Boolean.parseBoolean(request.get("is_paid").toString());
			
			BillDTO billtoinsert = new BillDTO (id_assignment , price , is_paid);
			billService.insert(billtoinsert);
			request = new Request ();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "BillInsert" , request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			billService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "BillDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			id_assignment= Integer.parseInt(request.get("id_assignment").toString());
			price = Double.parseDouble(request.get("price").toString());
			is_paid = Boolean.parseBoolean(request.get("is_paid").toString());
			
			BillDTO billtoupdate = new BillDTO(id_assignment , price , is_paid);
			billtoupdate.setId(id);
			billService.update(billtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "BillUpdate", request);
			break;
			
		case "BILLLIST":
			//maybe it does not need to create a request object and to specify the sub_package
					//because this method has not an input
			List<BillDTO> billDTOlist = billService.getAllBill();
			request.put("bills" , billDTOlist);
			MainDispatcher.getInstance().callView("Bill" , request);
			break;
			
		case "GETCHOICE":
			
			switch (choice.toUpperCase()) {
				
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "BillRead", null);
				break;
		
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "BillInsert", null);			
				break;
			
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "BillUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "BillDelete", null);
				break;
			
			case "E":  //exit
				MainDispatcher.getInstance().callView("Login", null);
				break;
			
			case "B":  //back
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			//default of switch(choice)
			default:
				MainDispatcher.getInstance().callView("Login", null);		
			}
		//default of switch(mode)	
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
		
	}
	
	
}
