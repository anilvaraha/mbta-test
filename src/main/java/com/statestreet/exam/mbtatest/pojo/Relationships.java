package com.statestreet.exam.mbtatest.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relationships {

	@SerializedName("line")
	@Expose
	private Line line;

	public Line getLine() {
	return line;
	}

	public void setLine(Line line) {
	this.line = line;
	}

}
