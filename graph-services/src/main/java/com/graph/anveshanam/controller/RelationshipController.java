package com.graph.anveshanam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graph.anveshanam.domain.BaseEntity;
import com.graph.anveshanam.domain.BaseRelationship;
import com.graph.anveshanam.services.EntityService;
import com.graph.anveshanam.services.RelationshipService;


@RestController("/relationship")
public class RelationshipController {

	
	
	@Autowired
	public EntityService entityService;
	
	@Autowired
	public RelationshipService relationshipService;
	

	
	

	
	@RequestMapping("/ping")
	public String ping() {
		return "ping";
	}
	
	@RequestMapping(path="/create",method=RequestMethod.POST ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody BaseRelationship relationship) {
		
		
		return "created";
	}
	

	@RequestMapping(path="/find",method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	public BaseRelationship find(@RequestParam("value") String value ) {
		BaseEntity entity =entityService.findbyValue(value);
		//movieService.find();
		return null;
	}
	
	
}