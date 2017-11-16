package com.unknown8.esc.model;

public class Calculations {

	private int newBill;
	private int savings;

	public void savings(int newBill, int wAC) {

		savings = wAC - newBill;
	}

	public int getSavings() {
		return savings;
	}
	
	

	public int getNewBill() {
		
		return newBill;
	}

	public void setNewBill(int newBill) {
		this.newBill = newBill;
	}

}
