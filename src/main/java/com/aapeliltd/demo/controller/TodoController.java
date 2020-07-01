package com.aapeliltd.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aapeliltd.demo.model.Todo;
import com.aapeliltd.demo.repository.TodoRepository;

@Controller
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping
	public String index() {
		
		return "index";
		
	}
	
	private void getTodoModel(Model model) {
		
		model.addAttribute("todos", todoRepository.findAll());
	}
	
	private String redirectToTodos() {
		
		return "redirect:/todos";
	}
	
	@GetMapping("/todos")
	public String todos(Model model) {	
		getTodoModel(model);	
		return "todos";
	}
	
	@PostMapping("/todoNew")
	public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
		Todo todo = new Todo(todoItem, status);
		todoRepository.save(todo);
		getTodoModel(model);
		return redirectToTodos();
	}
	
	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		todoRepository.deleteById(id);
		getTodoModel(model);
		return redirectToTodos();
	}
	
	@PostMapping("/todoUpdate/{id}")
	public String update(@PathVariable long id, Model model) {
		Optional<Todo> todo = todoRepository.findById(id);
		if("Yes".equals(todo.get().getCompleted())) {
			todo.get().setCompleted("No");
		}else {
			todo.get().setCompleted("Yes");
		}
		todoRepository.save(todo.get());		
		getTodoModel(model);
		return redirectToTodos();
	}
	
	

}
