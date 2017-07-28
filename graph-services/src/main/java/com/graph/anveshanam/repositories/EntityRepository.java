package com.graph.anveshanam.repositories;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.graph.anveshanam.domain.BaseEntity;

@RepositoryRestResource(collectionResourceRel = "entity", path = "entities")
public interface EntityRepository extends PagingAndSortingRepository<BaseEntity, Long> {
	
	BaseEntity findByKey(@Param("key") String title);
	
	BaseEntity findById(@Param("id") String id);

	Collection<BaseEntity> findByKeyLike(@Param("key") String title);

	
}
