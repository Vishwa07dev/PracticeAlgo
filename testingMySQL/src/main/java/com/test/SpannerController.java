package com.test;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/ap1/spanner")
public class SpannerController {
	private final SpannerRepository repo ;
	@Autowired
	public SpannerController(SpannerRepository repo){
		this.repo=repo;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(org.springframework.http.HttpStatus.FOUND)
	List<Spanners> getAllSpanners(){
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	Spanners createSpanner(@RequestBody @Valid Spanners spanner){
		return repo.save(spanner);
	}

}
