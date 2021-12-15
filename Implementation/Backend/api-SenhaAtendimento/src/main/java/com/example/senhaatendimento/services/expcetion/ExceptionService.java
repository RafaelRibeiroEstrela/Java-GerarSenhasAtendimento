package com.example.senhaatendimento.services.expcetion;

public class ExceptionService extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExceptionService(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionService(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
