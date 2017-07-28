package com.graph.anveshanam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graph.anveshanam.domain.BaseEntity;
import com.graph.anveshanam.services.EntityService;


@RestController("/entity")
public class EntityController {

	
	@Autowired
	public EntityService entityService;
	
	
	
	

	
	@RequestMapping("/ping")
	public String ping() {
		return "ping";
	}
	
	@RequestMapping(path="/create",method=RequestMethod.POST ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody BaseEntity entity) {
		
		entityService.create(entity);
		return "created";
	}
	

	@RequestMapping(path="/find",method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	public BaseEntity find(@RequestParam("value") String value ) {
		BaseEntity entity =entityService.findbyValue(value);
		//movieService.find();
		return entity;
	}
	

}