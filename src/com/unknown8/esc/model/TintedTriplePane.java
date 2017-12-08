package com.unknown8.esc.model;

public class TintedTriplePane extends Windows {

	public double savingsValue = 0.62;
	public double rValue = 3.8;
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