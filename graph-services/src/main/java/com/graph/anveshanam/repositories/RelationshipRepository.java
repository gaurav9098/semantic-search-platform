package com.graph.anveshanam.repositories;

import java.util.Collection;

import org.springframework.data.repository.query.Param;

import com.graph.anveshanam.domain.BaseRelationship;

public interface RelationshipRepository {

	BaseRelationship findByLabel(@Param("label") String relationshipLabel);
	
	BaseRelationship findById(@Param("id") String id);

	Collection<BaseRelationship> findByLabelLike(@Param("label") String relationshipLabel);
	
}
