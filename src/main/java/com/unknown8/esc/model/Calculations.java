package com.unknown8.esc.model;

public class Calculations {

	public static double newBill;
	private static double wAC;
	private double savings;
	private String windowType;
	private String doorType;

	static SinglePane sp = new SinglePane();
	static DoublePane dp = new DoublePane();
	static TriplePane tp = new TriplePane();
	static ParticleBoard pb = new ParticleBoard();
	static HardWood hw = new HardWood();

	static double spv = sp.getSV();
	static double dpv = dp.getSV();
	static double tpv = tp.getSV();
	static double pbv = pb.getSV();
	static double hwv = hw.getSV();

	public static double getNewBill(double wAC, String windowType, String doorType) {
		if (windowType.equals("Single Pane") && (doorType.equals("Particle Board"))) {
			newBill = wAC * spv * pbv;

		}

		if (windowType.equals("Single Pane") && (doorType.equals("Hardwood"))) {
			newBill = wAC * spv - (wAC * hwv);

		}

		if (windowType.equals("Double Pane") && (doorType.equals("Particle Board"))) {
			newBill =  wAC - (wAC * dpv) * pbv;

		}
		if (windowType.equals("Double Pane") && (doorType.equals("Hardwood"))) {
			newBill = wAC - (wAC * dpv) - (wAC * hwv);

		}

		if (windowType.equals("Triple Pane") && (doorType.equals("Particle Board"))) {
			newBill = wAC - (wAC * tpv) * pbv;

		}
		if (windowType.equals("Triple Pane") && (doorType.equals("Hardwood"))) {
			newBill = wAC - (wAC * tpv) - (wAC * hwv);

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

	public String getDoorType() {
		return doorType;
	}

	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}

	// Test
	/*public static void main(String[] args) {
		
		
		System.out.println("Bill w/ Single Pane Windows & ParticleBoard");
		getNewBill(75, "Single Pane", "Particle Board");
		System.out.println(newBill);
		
		System.out.println("Bill w/ Single Pane Windows & Hardwood");
		getNewBill(75, "Single Pane", "Hardwood");
		System.out.println(newBill);
		
		System.out.println("Bill w/ Double Pane Windows & ParticleBoard");
		getNewBill(75, "Double Pane", "Particle Board");
		System.out.println(newBill);
		
		System.out.println("Bill w/ Double Pane Windows & Hardwood");
		getNewBill(75, "Double Pane", "Hardwood");
		System.out.println(newBill);
	
		System.out.println("Bill w/ Triple Pane Windows & ParticleBoard");
		getNewBill(75, "Triple Pane", "Particle Board");
		System.out.println(newBill);
		
		System.out.println("Bill w/ Triple Pane Windows & Hardwood");
		getNewBill(75, "Triple Pane", "Hardwood");
		System.out.println(newBill);
		


	}*/

}
