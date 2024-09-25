package com.monckintoBusiness.MockintoBusiness.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;



import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
	
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to learn");
		
		//given
		given(todoService.retriveTodos("Ranga")).willReturn(allTodos);
		
		//when
		List<String> todos = todoBusiness.retriveTodoRelatedToSpring("Ranga");
		
		//then
		assertThat(todos.size(),is(2));

	}
	
	@Test
	public void deleteNowTest() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		
		when(todoService.retriveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

		todoBusiness.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService,Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService,Mockito.never()).deleteTodo("Learn Spring");
		
		verify(todoService,Mockito.times(1)).deleteTodo("Learn to Dance");

		
		

	}
	

}
