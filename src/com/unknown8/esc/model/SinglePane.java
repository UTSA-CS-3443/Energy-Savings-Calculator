package com.unknown8.esc.model;

public class SinglePane extends Windows {

	public double savingsValue = 1;
	public double rValue = 0.9;
	int area = width * height;

	public double getSV() {

		return savingsValue;
	}

	public double getRV() {

		return rValue;
	}

	public int getArea() {
		return area;

	}

}
