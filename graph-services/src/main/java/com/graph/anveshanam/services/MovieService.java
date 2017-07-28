package com.graph.anveshanam.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graph.anveshanam.domain.Movie;
import com.graph.anveshanam.domain.Role;
import com.graph.anveshanam.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired MovieRepository movieRepository;

	private Map<String, Object> toD3Format(Collection<Movie> movies) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Movie> result = movies.iterator();
		while (result.hasNext()) {
			Movie movie = result.next();
			nodes.add(map("title", movie.getTitle(), "label", "movie"));
			int target = i;
			i++;
			for (Role role : movie.getRoles()) {
				Map<String, Object> actor = map("title", role.getPerson().getName(), "label", "actor");
				int source = nodes.indexOf(actor);
				if (source == -1) {
					nodes.add(actor);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

	@Transactional(readOnly = true)
	public Map<String, Object>  graph(int limit) {
		Collection<Movie> result = movieRepository.graph(limit);
		return toD3Format(result);
	}
	
	@Transactional
	public void  create() {
		Movie movie = new Movie("KKH",1999);
		
		Map<String, Object> propMap= new HashMap<>();
		propMap.put("Cost", 250000000);
		propMap.put("Director", "Karan Jauhar");
		movie.setPropMap(propMap);
		movieRepository.save(movie);
		
	}
	@Transactional
	public void  find() {
		
		Movie movie=movieRepository.findByTitle("DDLJ");
		System.out.println(movie);
	}
	}