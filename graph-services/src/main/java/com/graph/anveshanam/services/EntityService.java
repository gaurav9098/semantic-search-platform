package com.graph.anveshanam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graph.anveshanam.MyConfiguration;
import com.graph.anveshanam.domain.BaseEntity;
import com.graph.anveshanam.repositories.EntityRepository;

@Service
public class EntityService {

	@Autowired EntityRepository entityRepository;
	@Autowired MyConfiguration myConfiguration;  
	@Transactional
	public void  create(BaseEntity tweet) {
		
		
		entityRepository.save(tweet);
		
	}
	
	@Transactional
	public BaseEntity  findById(String id) {
		
		BaseEntity entity=entityRepository.findById(id);
		System.out.println(entity);
		
		return entity;
	}
	
	@Transactional
	public BaseEntity  findbyValue(String value) {
		
		BaseEntity entity=entityRepository.findByKey(value);
		System.out.println(entity);
		return entity;
	}
	
	@Transactional
	public List<BaseEntity>  findbyValueLike(String value) {
		
		List<BaseEntity> entityList=(List<BaseEntity>) entityRepository.findByKeyLike(value);
		System.out.println(entityList);
		return entityList;
	}

	public MyConfiguration getMyConfiguration() {
		return myConfiguration;
	}

	public void setMyConfiguration(MyConfiguration myConfiguration) {
		this.myConfiguration = myConfiguration;
	}
	
}
