package com.rider.exception;

public class RiderNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public RiderNotFoundException(Long id){
		super(String.format("No interview experience found with id :" , id));
	}

}
