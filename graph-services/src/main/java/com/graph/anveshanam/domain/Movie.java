package com.graph.anveshanam.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Movie {

	@GraphId
	private Long id;

	private String title;

	private Map<String, Object> propMap;
	private int released;

	private String tagline;

	@Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
	private List<Role> roles = new ArrayList<>();

	public Movie() {
	}

	public Movie(String title, int released) {

		this.title = title;
		this.released = released;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public int getReleased() {
		return released;
	}

	public String getTagline() {
		return tagline;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public Map<String, Object> getPropMap() {
		return propMap;
	}

	public void setPropMap(Map<String, Object> propMap) {
		this.propMap = propMap;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleased(int released) {
		this.released = released;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}