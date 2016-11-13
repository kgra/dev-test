package com.goeuro.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.goeuro.model.Route;
import com.goeuro.repository.RouteRepository;

public class DirectRouteCheckServiceTest {

	RouteRepository repository = Mockito.mock(RouteRepository.class);
	DirectRouteCheckService sut;
	
	@Before
	public void setUp(){
		List<Route> routes = new ArrayList<>();
		Route firstRoute = new Route();
		firstRoute.id = 0;
		firstRoute.stops.add(0);
		firstRoute.stops.add(1);
		firstRoute.stops.add(2);
		firstRoute.stops.add(3);
		routes.add(firstRoute);
		
		Route secondRoute = new Route();
		secondRoute.id = 0;
		secondRoute.stops.add(7);
		secondRoute.stops.add(1);
		secondRoute.stops.add(3);
		secondRoute.stops.add(4);
		routes.add(secondRoute);
		
		Mockito.when(repository.getRoutes()).thenReturn(routes);
		
		sut = new DirectRouteCheckService(repository);
	}
	
	@Test
	public void shouldFindDirectRoute(){
		assertTrue(sut.isDirectRoute(7, 3));
	}
	
	@Test
	public void shouldNotFindDirectRoute(){
		assertFalse(sut.isDirectRoute(5, 4));
	}
}
