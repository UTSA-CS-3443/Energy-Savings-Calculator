package com.unknown8.esc.model;

public abstract class Windows {
	int height = 5;
	int width = 3;
	double savingsValue;
	double rValue;
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