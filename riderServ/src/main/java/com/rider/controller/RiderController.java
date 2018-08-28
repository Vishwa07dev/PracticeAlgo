package com.rider.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rider.exception.RiderNotFoundException;
import com.rider.model.Rider;
import com.rider.service.RiderService;

@RestController
@RequestMapping("api/v1/rider")
public class RiderController {
	
	private final RiderService riderService ;
	
	@Autowired
	public RiderController(RiderService riderService){
		this.riderService = riderService ;
	}
	
	@RequestMapping(method=RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	Rider createRider(@RequestBody @Valid Rider rider){
		return riderService.createRider(rider);
	}
	@RequestMapping(method=RequestMethod.GET)
	List<Rider> getAllRiders(){
		return riderService.findAllRiders();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleInterviewExpNotFound(RiderNotFoundException ex){
		
	}

}
