package com.goeuro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeuro.model.DirectRouteResponse;
import com.goeuro.service.DirectRouteCheckService;

@RestController
@RequestMapping("/api")
public class RouteCheckController {

	private DirectRouteCheckService checkService;

	@Autowired
	public RouteCheckController(DirectRouteCheckService checkService){
		this.checkService = checkService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/direct")
	public DirectRouteResponse directRouteCheck(@RequestParam(value = "dep_sid", required = true) int departure,
											    @RequestParam(value = "arr_sid", required = true) int arrival) {
		
		Boolean result = checkService.isDirectRoute(departure, arrival);
		return new DirectRouteResponse(departure, arrival, result);
	}
}
