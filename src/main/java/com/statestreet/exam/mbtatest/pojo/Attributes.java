package com.statestreet.exam.mbtatest.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

	@SerializedName("color")
	@Expose
	private String color;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("direction_destinations")
	@Expose
	private List<String> directionDestinations = null;
	@SerializedName("direction_names")
	@Expose
	private List<String> directionNames = null;
	@SerializedName("fare_class")
	@Expose
	private String fareClass;
	@SerializedName("long_name")
	@Expose
	private String longName;
	@SerializedName("short_name")
	@Expose
	private String shortName;
	@SerializedName("sort_order")
	@Expose
	private Integer sortOrder;
	@SerializedName("text_color")
	@Expose
	private String textColor;
	@SerializedName("type")
	@Expose
	private Integer type;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getDirectionDestinations() {
		return directionDestinations;
	}

	public void setDirectionDestinations(List<String> directionDestinations) {
		this.directionDestinations = directionDestinations;
	}

	public List<String> getDirectionNames() {
		return directionNames;
	}

	public void setDirectionNames(List<String> directionNames) {
		this.directionNames = directionNames;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(String fareClass) {
		this.fareClass = fareClass;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Attributes [color=" + color + ", description=" + description + ", directionDestinations="
				+ directionDestinations + ", directionNames=" + directionNames + ", fareClass=" + fareClass
				+ ", longName=" + longName + ", shortName=" + shortName + ", sortOrder=" + sortOrder + ", textColor="
				+ textColor + ", type=" + type + "]";
	}

}
