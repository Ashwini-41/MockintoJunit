package com.monckintoBusiness.MockintoBusiness.business;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.monckintoBusiness.MockintoBusiness.data.TodoService;
import com.monckintoBusiness.MockintoBusiness.data.TodoServiceStub;

class TodoBusinessImplStubTest {

	@Test
	public void usingStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todobusiness = new TodoBusinessImpl(todoService);
		
		List<String> todos = todobusiness.retriveTodoRelatedToSpring("Ranga");
		assertEquals(2,todos.size());
	}

}
