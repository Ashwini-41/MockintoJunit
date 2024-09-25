package com.monckintoBusiness.MockintoBusiness.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.monckintoBusiness.MockintoBusiness.data.TodoService;

@ExtendWith(MockitoExtension.class)
class TodoBusinessMockitoInjectMocksTest {

	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBusiness;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void usingMockitoTest() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC" , "Learn Spring" , "Learn to Dance");
		
		when(todoService.retriveTodos("Ranga")).thenReturn(allTodos);
		
		List<String> todos = todoBusiness.retriveTodoRelatedToSpring("Ranga");
		assertEquals(2,todos.size());
	}
	
	@Test
	public void usingMockito_UsingBDD() {
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
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		
		when(todoService.retriveTodos("Ranga")).thenReturn(allTodos);
		

		todoBusiness.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService,Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService,Mockito.never()).deleteTodo("Learn Spring");
		
		verify(todoService,Mockito.times(1)).deleteTodo("Learn to Dance");

		
		

	}
	
	@Test
	public void captureArgument() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		
		Mockito.when(todoService.retriveTodos("Ranga")).thenReturn(allTodos);
		
		todoBusiness.deleteTodosNotRelatedToSpring("Ranga");
		
		Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());
		
		assertEquals("Learn to Dance",argumentCaptor.getValue());
		
	}


}
