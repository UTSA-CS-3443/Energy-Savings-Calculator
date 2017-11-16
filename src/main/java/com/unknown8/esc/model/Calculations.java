package com.unknown8.esc.model;

public class Calculations {

	public static double newBill;
	private static double wAC;
	private double savings;
	private String windowType;

	static SinglePane sp = new SinglePane();
	static DoublePane dp = new DoublePane();
	static TriplePane tp = new TriplePane();

	static double spv = sp.getSV();
	static double dpv = dp.getSV();
	static double tpv = tp.getSV();

	
	public static double getNewBill(double wAC , String windowType) {
		if (windowType.equals("SinglePane")) {
			newBill = wAC * spv;
		
		}
		if (windowType.equals("DoublePane")) {
			newBill = wAC - (wAC * dpv);
			
		}
		if (windowType.equals("TriplePane")) {
			newBill = wAC - (wAC * tpv);
			
		}
		return newBill;

	}

	public void savings(double newBill, double wAC) {
		savings = wAC - newBill;
	}

	public double getSavings() {
		return savings;
	}

	public String getWindowType() {
		return windowType;
	}

	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}
	public static double getwAC() {
		return wAC;
	}

	public static void setwAC(double wAC) {
		Calculations.wAC = wAC;
	}

	
//Test
 public static void main(String[] args){
	System.out.println("Bill w/ Single Pane Windows");
	getNewBill(100, "SinglePane");
	System.out.println(newBill);
	System.out.println("Bill w/ Double Pane Windows");
	getNewBill(100, "DoublePane");
	System.out.println(newBill);
	System.out.println("Bill w/ Triple Pane Windows");
	getNewBill(100, "TriplePane");
	System.out.println(newBill);
	 
	 
 }


}
