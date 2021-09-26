package com.statestreet.exam.mbtatest.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Line {

	@SerializedName("data")
	@Expose
	private LineData data;

	public LineData getData() {
		return data;
	}

	public void setData(LineData data) {
		this.data = data;
	}

}