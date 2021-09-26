package com.statestreet.exam.mbtatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.statestreet.exam.mbtatest.exception.RestCustomException;
import com.statestreet.exam.mbtatest.service.RoutesService;

@RestController
public class RoutesController {

	@Autowired
	private RoutesService routesService;

	@GetMapping("/commuter/routes/longnames")
	public List<String> getRoutes() {
		List<String> routes = new ArrayList<String>();
		try {
			routes = routesService.getLongNameOfRoutes();
		} catch (RestCustomException e) {
			routes.add(e.getMessage());
		}

		return routes;
	}

	@GetMapping("/commuter/routes/stops")
	public List<String> getStopsForRoute(@RequestParam(name = "routeName") String routeName) {
		List<String> stops = new ArrayList<String>();
		try {
			return routesService.getStopsForARoute(routeName);
		} catch (RestCustomException e) {
			stops.add(e.getMessage());
		}

		return stops;
	}

	@GetMapping("/commuter/routes/name")
	public String getCommuterRailDetails(@RequestParam(name = "from") String from,
			@RequestParam(name = "to") String to) {
		try {
			return routesService.getRouteName(from, to);
		} catch (RestCustomException e) {
			return e.getMessage();
		}
	}

}
