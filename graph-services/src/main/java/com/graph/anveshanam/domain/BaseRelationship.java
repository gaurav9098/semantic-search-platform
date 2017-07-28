package com.graph.anveshanam.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type="CITY_OF")
public class BaseRelationship {

	
	@GraphId
	private Long id;
	private String propertyMap;
	
	 @Property
	private String relationshipType;
	 
	 @Property
	private String relationshipDirection;
	 
	 @StartNode
	private BaseEntity fromNode;
	 
	 @EndNode
	private BaseEntity	toNode;
	
	 @Property
	private boolean isDeleted;
	 
	 @Property
	 @Index(unique=true)
	private String label;
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPropertyMap() {
		return propertyMap;
	}
	public void setPropertyMap(String propertyMap) {
		this.propertyMap = propertyMap;
	}
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	public String getRelationshipDirection() {
		return relationshipDirection;
	}
	public void setRelationshipDirection(String relationshipDirection) {
		this.relationshipDirection = relationshipDirection;
	}
	public BaseEntity getFromNode() {
		return fromNode;
	}
	public void setFromNode(BaseEntity fromNode) {
		this.fromNode = fromNode;
	}
	public BaseEntity getToNode() {
		return toNode;
	}
	public void setToNode(BaseEntity toNode) {
		this.toNode = toNode;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
