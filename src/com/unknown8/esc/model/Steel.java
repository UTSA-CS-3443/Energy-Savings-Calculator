package com.unknown8.esc.model;

public class Steel extends Doors {
	public double savingsValue = .4;
	public double rValue = 2.45;
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
