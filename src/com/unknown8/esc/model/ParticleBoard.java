package com.unknown8.esc.model;

public class ParticleBoard extends Doors {
	public double savingsValue = 1;
	public double rValue = 0.53;
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
