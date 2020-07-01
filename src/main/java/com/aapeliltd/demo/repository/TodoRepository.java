package com.aapeliltd.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.aapeliltd.demo.model.Todo;

public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>  {
	
	

}
