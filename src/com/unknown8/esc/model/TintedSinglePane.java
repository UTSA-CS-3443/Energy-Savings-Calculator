package com.unknown8.esc.model;


public class TintedSinglePane extends Windows {

	public double savingsValue = .2;
	public double rValue = 1.5;
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

