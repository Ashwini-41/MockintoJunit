package com.monckintoBusiness.MockintoBusiness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void mockListSizetest() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10);
		assertEquals(10,list.size());
	
	}
	
	@Test
	public void mockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10,list.size());
		assertEquals(20,list.size());
		
	}
	
	@Test
	public void MockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("ashwini");
		assertEquals("ashwini",list.get(0));
		assertNull(list.get(1));
	}
	@Test
	//(expected = RuntimeException.class) // junit-4 annotation not allowed in junit 5
	public void mockListGetToThrowException() {
		List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("error occurred something went wrong"));
        
        assertThrows(RuntimeException.class,() -> {
        	list.get(0);
        });
        //list.get(0);
	}
	
	@Test
	public void mockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("ashwini");
		
		assertEquals("ashwini",list.get(0));
		assertEquals("ashwini",list.get(1));

	}
	
	@Test
	public void bddAliases_UsingGivenReturn() {
		List<String> list = mock(List.class);
		
		//given
		given(list.get(Mockito.anyInt())).willReturn("classes");
		
		//then
		assertThat("classes",is(list.get(0)));
		assertThat("classes",is(list.get(0)));
	}
	

}
