package com.monckintoBusiness.MockintoBusiness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
	public void mockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("ashwini");
		
		assertEquals("ashwini",list.get(0));
		assertEquals("ashwini",list.get(1));

	}

}
