package com.goeuro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.goeuro.model.Route;
import com.goeuro.repository.RouteRepository;

@SpringBootApplication
public class GoeuroApplication {
	static List<Route> routes = new ArrayList<>();
	
	public static void main(String[] args) {
		loadRoutes(args[1]);
		SpringApplication.run(GoeuroApplication.class, args);	
	}
	
	@Bean
    public RouteRepository routeRepository() {
        return new RouteRepository(routes);
    }
	
	private static void loadRoutes(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int routesCount = Integer.parseInt(br.readLine());

			for (int i = 0; i < routesCount; i++) {
				String line = br.readLine();
				String[] stops = line.split("\\s+");

				Route route = new Route();
				route.id = Integer.parseInt(stops[0]);

				for (int j = 1; j < stops.length; j++) {
					route.stops.add(Integer.parseInt(stops[j]));
				}
				routes.add(route);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
