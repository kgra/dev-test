package com.goeuro.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeuro.model.Route;
import com.goeuro.repository.RouteRepository;

@Service
public class DirectRouteCheckService {

	RouteRepository repository;

	@Autowired
	public DirectRouteCheckService(RouteRepository repository) {
		this.repository = repository;
	}

	public Boolean isDirectRoute(int departure, int arrival) {
		List<Route> routes = repository.getRoutes();
		Predicate<Route> predicate = route -> route.stops.contains(departure) && route.stops.contains(arrival);
		return routes.stream().anyMatch(predicate);
	}
}
