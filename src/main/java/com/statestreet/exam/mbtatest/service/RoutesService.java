package com.statestreet.exam.mbtatest.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.statestreet.exam.mbtatest.exception.RestCustomException;
import com.statestreet.exam.mbtatest.helper.RoutesResponseHelper;
import com.statestreet.exam.mbtatest.pojo.Data;
import com.statestreet.exam.mbtatest.pojo.RoutesTo;

@Service
public class RoutesService {

	@Value("${apiUrl}")
	private String apiUrl;
	
	@Autowired
	@Qualifier("routesTemplate")
	private RestTemplate routesTemplate;

	private RoutesTo routesData;

	private RoutesTo getRoutes() throws RestCustomException {

		try {
			ResponseEntity<String> response = routesTemplate.getForEntity(apiUrl + "routes?filter[type]=2",
					String.class);
			if (response.getStatusCode().is2xxSuccessful()) {
				String responseStr = response.getBody();
				routesData = (new Gson()).fromJson(responseStr, RoutesTo.class);
				routesData.getData().stream().forEach(d -> d.setStopsList(getStops(d.getId())));
			} else {
				JsonArray obj = RoutesResponseHelper.getJsonObject(response.getBody()).getAsJsonArray("errors");
				JsonObject error = obj.get(0).getAsJsonObject();
				throw new RestCustomException(error.getAsJsonPrimitive("detail").getAsString(), new Exception());
			}
		} catch (RestClientException e) {
			throw new RestCustomException("Unable to connect to backend service.", e);
		}

		return routesData;
	}

	public List<String> getLongNameOfRoutes() throws RestCustomException {
		getRoutes();
		List<String> longNamesList = RoutesResponseHelper.getRoutesLongName(routesData);
		return longNamesList;
	}

	public List<String> getStopsForARoute(String routeName) throws RestCustomException {

		if (Objects.isNull(routesData)) {
			getRoutes();
		}
		Data data = routesData.getData().stream()
				.filter(d -> d.getAttributes().getLongName().equalsIgnoreCase(routeName)).findFirst().orElse(null);
		if (data != null) {
			return data.getStopsList();
		}
		return null;

	}

	private List<String> getStops(String routeId) {

		ResponseEntity<String> response = routesTemplate.getForEntity(apiUrl + "stops?filter[route]=" + routeId,
				String.class);
		String responseStr = response.getBody();
		List<String> stopList = RoutesResponseHelper
				.getListOfStopsForRoute(RoutesResponseHelper.getJsonObject(responseStr));
		return stopList;
	}

	public String getRouteName(String from, String to) throws RestCustomException {
		if (Objects.isNull(routesData)) {
			getRoutes();
		}
		Data commuterLine = this.routesData.getData().stream()
				.filter(d -> (d.getStopsList().contains(from) && d.getStopsList().contains(to))).findAny().orElse(null);
		if (commuterLine != null) {
			return commuterLine.getAttributes().getLongName();
		}
		return null;
	}

}
