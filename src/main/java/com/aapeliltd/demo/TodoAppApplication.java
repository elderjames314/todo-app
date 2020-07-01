package com.aapeliltd.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aapeliltd.demo.model.Todo;
import com.aapeliltd.demo.repository.TodoRepository;

@SpringBootApplication
public class TodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
	
	@Autowired
	private TodoRepository todoRository;
	
	
	
	@PostConstruct
	public void seeds() {
		
		Collection<Todo> todos = Arrays.asList(
				new Todo("Need to go out", "Yes"),
				new Todo("will go libreay later", "No"),
				new Todo("Market ", "Yes"),
				new Todo("Have to stay home all through", "Yes"),
				new Todo("Max will goto school", "Yes"),
				new Todo("Need to go out", "Yes")
				);
		
		todos.forEach(todoRository::save);
		
	}

}
