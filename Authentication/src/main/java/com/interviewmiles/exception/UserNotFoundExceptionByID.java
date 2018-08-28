package com.interviewmiles.exception;

public class UserNotFoundExceptionByID extends RuntimeException{
	public UserNotFoundExceptionByID(String id){
		   super(String.format("No User found with id : ", id));
	   }
}
