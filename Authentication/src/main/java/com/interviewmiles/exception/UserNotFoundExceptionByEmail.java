package com.interviewmiles.exception;

public class UserNotFoundExceptionByEmail extends RuntimeException {

	public UserNotFoundExceptionByEmail(String emailId){
		   super(String.format("No User found with id : ", emailId));
	   }
}
