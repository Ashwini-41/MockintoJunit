package com.monckintoBusiness.MockintoBusiness.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.monckintoBusiness.MockintoBusiness.data.TodoService;

class TodoBusinesslMockitoTest {

	@Test
	public void usingMockitoTest() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC" , "Learn Spring" , "Learn to dance");
		
		when(todoService.retriveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusiness.retriveTodoRelatedToSpring("Ranga");
		assertEquals(2,todos.size());
	}

}
