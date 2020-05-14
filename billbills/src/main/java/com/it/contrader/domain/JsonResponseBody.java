package com.it.contrader.domain;

import java.util.List;

import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor
public class JsonResponseBody{
	
	public JsonResponseBody(int server , Object response) {
		this.server= server;
		this.response= response;
	}
	
	@Getter
	@Setter
	private int server;
	
	private Object response;
	
	public Object getResponse() {
	  return this.response;
	}
	
	public void setResponse(Object response) {
	  this.response=response ;
	    }
}
