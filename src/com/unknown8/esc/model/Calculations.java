package com.unknown8.esc.model;

public class Calculations {

	public double newBill;
	private double wAC;
	private double saveable;
	private double savings;
	private String windowType;
	private String doorType;

	static SinglePane sp = new SinglePane();
	static DoublePane dp = new DoublePane();
	static TriplePane tp = new TriplePane();
	static ParticleBoard pb = new ParticleBoard();
	static HardWood hw = new HardWood();
	static TintedSinglePane tsp = new TintedSinglePane();
	static TintedDoublePane tdp = new TintedDoublePane();
	static TintedTriplePane ttp = new TintedTriplePane();
	static Steel st = new Steel();

	static double spv = sp.getSV();
	static double dpv = dp.getSV();
	static double tpv = tp.getSV();
	static double pbv = pb.getSV();
	static double hwv = hw.getSV();
	static double stv = st.getSV();
	static double tspv = tsp.getSV();
	static double tdpv = tdp.getSV();
	static double ttpv = ttp.getSV();

	public double getNewBill(double wAC, double woAC, String windowType, String doorType) {
		this.saveable = wAC - woAC;
		this.wAC = wAC;
		if (windowType.equals("SinglePane") && (doorType.equals("ParticleBoard"))) {
			newBill = saveable * spv * pbv;

		}

		if (windowType.equals("SinglePane") && (doorType.equals("Hardwood"))) {
			newBill = saveable * spv - (saveable * hwv);

		}

		if (windowType.equals("SinglePane") && (doorType.equals("Steel"))) {
			newBill = saveable * spv - (saveable * stv);

		}

		if (windowType.equals("TintedSinglePane") && doorType.equals("ParticleBoard")) {
			newBill = saveable - (saveable * tspv) * pbv;
		}

		if (windowType.equals("TintedSinglePane") && doorType.equals("Hardwood")) {
			newBill = saveable - (saveable * tspv) - (saveable * hwv);
		}

		if (windowType.equals("TintedSinglePane") && doorType.equals("Steel")) {
			newBill = saveable - (saveable * tspv) - (saveable * stv);
		}

		if (windowType.equals("DoublePane") && (doorType.equals("ParticleBoard"))) {
			newBill = saveable - (saveable * dpv) * pbv;

		}
		if (windowType.equals("DoublePane") && (doorType.equals("Hardwood"))) {
			newBill = saveable - (saveable * dpv) - (saveable * hwv);

		}
		if (windowType.equals("DoublePane") && (doorType.equals("Steel"))) {
			newBill = saveable - (saveable * dpv) - (saveable * stv);

		}

		if (windowType.equals("TintedDoublePane") && doorType.equals("ParticleBoard")) {
			newBill = saveable - (saveable * tdpv) * pbv;
		}

		if (windowType.equals("TintedDoublePane") && doorType.equals("Hardwood")) {
			newBill = saveable - (saveable * tdpv) - (saveable * hwv);
		}

		if (windowType.equals("TintedDoublePane") && doorType.equals("Steel")) {
			newBill = saveable - (saveable * tdpv) - (saveable * stv);
		}

		if (windowType.equals("TriplePane") && (doorType.equals("ParticleBoard"))) {
			newBill = saveable - (saveable * tpv) * pbv;

		}
		if (windowType.equals("TriplePane") && (doorType.equals("Hardwood"))) {
			newBill = saveable - (saveable * tpv) - (saveable * hwv);

		}

		if (windowType.equals("TriplePane") && (doorType.equals("Steel"))) {
			newBill = saveable - (saveable * tpv) - (saveable * stv);

		}
		if (windowType.equals("TintedTriplePane") && doorType.equals("ParticleBoard")) {
			newBill = saveable - (saveable * ttpv) * pbv;
		}

		if (windowType.equals("TintedTriplePane") && doorType.equals("Hardwood")) {
			newBill = saveable - (saveable * ttpv) - (saveable * hwv);
		}

		if (windowType.equals("TintedTriplePane") && doorType.equals("Steel")) {
			newBill = saveable - (saveable * ttpv) - (saveable * stv);
		
		}
		
		newBill += woAC;
		return newBill;

	}

	public void savings(double wAC, double newBill) {
		savings = wAC - newBill;

	}

	public double getSavings() {
		savings(wAC, newBill);
		return savings;
	}

	public String getWindowType() {
		return windowType;
	}

	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}

	public double getwAC() {
		return wAC;
	}

	// public void setwAC(double wAC) {
	// Calculations.wAC = wAC;
	// }

	public String getDoorType() {
		return doorType;
	}

	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}

	// Test
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * System.out.println("Bill w/ Single Pane Windows & ParticleBoard");
	 * getNewBill(75, "Single Pane", "Particle Board"); System.out.println(newBill);
	 * 
	 * System.out.println("Bill w/ Single Pane Windows & Hardwood"); getNewBill(75,
	 * "Single Pane", "Hardwood"); System.out.println(newBill);
	 * 
	 * System.out.println("Bill w/ Double Pane Windows & ParticleBoard");
	 * getNewBill(75, "Double Pane", "Particle Board"); System.out.println(newBill);
	 * 
	 * System.out.println("Bill w/ Double Pane Windows & Hardwood"); getNewBill(75,
	 * "Double Pane", "Hardwood"); System.out.println(newBill);
	 * 
	 * System.out.println("Bill w/ Triple Pane Windows & ParticleBoard");
	 * getNewBill(75, "Triple Pane", "Particle Board"); System.out.println(newBill);
	 * 
	 * System.out.println("Bill w/ Triple Pane Windows & Hardwood"); getNewBill(75,
	 * "Triple Pane", "Hardwood"); System.out.println(newBill);
	 * 
	 * 
	 * 
	 * }
	 */

}
