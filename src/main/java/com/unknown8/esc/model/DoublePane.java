package com.unknown8.esc.model;

public class DoublePane extends Windows {

	public double savingsValue = 0.25;
	public double rValue = 2.04;
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
