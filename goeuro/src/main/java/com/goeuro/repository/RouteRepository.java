package com.goeuro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeuro.model.Route;

@Service
public class RouteRepository {
	private List<Route> routes;

	@Autowired
	public RouteRepository(List<Route> routes) {
		this.routes = routes;
	}

	public List<Route> getRoutes() {
		return routes;
	}
}
