package com.statestreet.exam.mbtatest.helper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.statestreet.exam.mbtatest.pojo.RoutesTo;

public class RoutesResponseHelper {

	public static Function<JsonElement, String> getStopName = (jsonElement) -> {

		JsonObject attr = jsonElement.getAsJsonObject().getAsJsonObject("attributes");
		String name = attr.getAsJsonPrimitive("name").getAsString();
		return name;
	};

	public static JsonObject getJsonObject(String responseStr) {

		JsonObject jsonObject = JsonParser.parseString(responseStr).getAsJsonObject();
		return jsonObject;
	}

	public static List<String> getRoutesLongName(RoutesTo routes) {

		List<String> longNameList = routes.getData().stream().map(d -> d.getAttributes().getLongName())
				.filter(longName -> !longName.isEmpty()).distinct().collect(Collectors.toList());
		return longNameList;
	}

	public static List<String> getListOfStopsForRoute(JsonObject obj) {
		JsonArray data = obj.getAsJsonArray("data");
		List<String> ls = StreamSupport.stream(data.spliterator(), true)
				.map(jsonElement -> getStopName.apply(jsonElement)).filter(name -> !name.isEmpty()).distinct()
				.collect(Collectors.toList());
		return ls;
	}
}
