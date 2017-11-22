package com.unknown8.esc.model;

public class HardWood extends Doors {
	public double savingsValue = .25;
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
