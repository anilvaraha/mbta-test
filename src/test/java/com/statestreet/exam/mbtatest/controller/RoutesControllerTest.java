package com.statestreet.exam.mbtatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.statestreet.exam.mbtatest.exception.RestCustomException;
import com.statestreet.exam.mbtatest.service.RoutesService;

@RunWith(MockitoJUnitRunner.class)
public class RoutesControllerTest {
	
	@InjectMocks
	RoutesController controller;
	@Mock
	RoutesService rs;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRoutes() throws RestCustomException {
		List<String> ls= new ArrayList<>();	
		ls.add("Route 1");
		ls.add("Route 2");
		Mockito.when(rs.getLongNameOfRoutes()).thenReturn(ls);
		Assert.assertTrue(!controller.getRoutes().isEmpty());
	}
	
	@Test
	public void testGetRoutesForException() throws RestCustomException {
		Mockito.when(rs.getLongNameOfRoutes()).thenThrow(new RestCustomException("New exception", new Exception()));
		Assert.assertTrue(controller.getRoutes().get(0).equalsIgnoreCase("New exception"));
	}

	@Test
	public void testGetStopsForRoute() throws RestCustomException {

		List<String> ls= new ArrayList<>();	
		ls.add("Route 1");
		ls.add("Route 2");
		Mockito.when(rs.getStopsForARoute(Mockito.anyString())).thenReturn(ls);
		Assert.assertTrue(!controller.getStopsForRoute("").isEmpty());
	
	}
	
	@Test
	public void testGetStopsForRouteForException() throws RestCustomException {
		Mockito.when(rs.getStopsForARoute(Mockito.anyString())).thenThrow(new RestCustomException("New exception", new Exception()));
		Assert.assertTrue(controller.getStopsForRoute("").get(0).equalsIgnoreCase("New exception"));
	}

	@Test
	public void testGetCommuterRailDetails() throws RestCustomException {
		Mockito.when(rs.getRouteName(Mockito.anyString(),Mockito.anyString())).thenReturn("Fairmount");
		Assert.assertTrue(controller.getCommuterRailDetails("from","to").equalsIgnoreCase("Fairmount"));
	}

	@Test
	public void testGetCommuterRailDetailsForException() throws RestCustomException {
		Mockito.when(rs.getRouteName(Mockito.anyString(),Mockito.anyString())).thenThrow(new RestCustomException("New exception", new Exception()));
		Assert.assertTrue(controller.getCommuterRailDetails("from","to").equalsIgnoreCase("New exception"));
	}
}
