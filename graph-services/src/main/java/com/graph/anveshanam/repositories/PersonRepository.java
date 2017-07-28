package com.graph.anveshanam.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.graph.anveshanam.domain.Person;


@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}