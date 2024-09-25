package com.monckintoBusiness.MockintoBusiness.business;

import java.util.ArrayList;
import java.util.List;

import com.monckintoBusiness.MockintoBusiness.data.TodoService;

public class TodoBusinessImpl {
      
	private TodoService todoService;
	
	TodoBusinessImpl(TodoService todoService){
		super();
		this.todoService = todoService;
	}
	
	public List<String> retriveTodoRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retriveTodos(user);
		
		for(String todo : allTodos) {
			
			if(todo.contains("Spring")) {
			filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user){
		List<String> allTodos = todoService.retriveTodos(user);
		
		for(String todo : allTodos) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
	
}
