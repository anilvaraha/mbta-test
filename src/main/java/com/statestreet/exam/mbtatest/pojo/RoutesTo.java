package com.statestreet.exam.mbtatest.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoutesTo {

	@SerializedName("data")
	@Expose
	private List<Data> data = new ArrayList<Data>();

	
	
	
	

	public List<Data> getData() {
	return data;
	}

	public void setData(List<Data> data) {
	this.data = data;
	}

	@Override
	public String toString() {
		return "RoutesTo [data=" + data +"]";
	}
	
	
	
}
