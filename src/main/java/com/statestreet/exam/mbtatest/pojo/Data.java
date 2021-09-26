package com.statestreet.exam.mbtatest.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("attributes")
	@Expose
	private Attributes attributes;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("links")
	@Expose
	private Links links;
	@SerializedName("relationships")
	@Expose
	private Relationships relationships;
	@SerializedName("type")
	@Expose
	private String type;
	
	private List<String> stopsList;

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public Relationships getRelationships() {
		return relationships;
	}

	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public List<String> getStopsList() {
		return stopsList;
	}

	public void setStopsList(List<String> stopsList) {
		this.stopsList = stopsList;
	}
	
	@Override
	public String toString() {
		return "Data [attributes=" + attributes + ", id=" + id + ", links=" + links + ", relationships=" + relationships
				+ ", type=" + type + " stops="+stopsList+ "]";
	}

}
