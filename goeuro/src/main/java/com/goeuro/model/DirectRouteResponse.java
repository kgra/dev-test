package com.goeuro.model;

public class DirectRouteResponse {
	public int dep_sid;
	public int arr_sid;
	public Boolean direct_bus_route;
	
	public DirectRouteResponse(int dep_sid, int arr_sid, Boolean direcr_bus_route){
		this.dep_sid = dep_sid;
		this.arr_sid = arr_sid;
		direct_bus_route = direcr_bus_route;
	}
}
