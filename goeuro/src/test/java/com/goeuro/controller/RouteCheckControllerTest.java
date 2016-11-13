package com.goeuro.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.goeuro.service.DirectRouteCheckService;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteCheckController.class)
public class RouteCheckControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	DirectRouteCheckService service;

	@Test
	public void controllerShouldReturnCorrectResult() throws Exception {
		given(this.service.isDirectRoute(1, 2)).willReturn(true);
		
		this.mvc.perform(get("/api/direct?dep_sid=1&arr_sid=2")
				.accept(MediaType.ALL))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"dep_sid\":1,\"arr_sid\":2,\"direct_bus_route\":true}"));
	}
}
