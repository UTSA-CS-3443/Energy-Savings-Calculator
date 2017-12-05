package com.unknown8.esc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SaveFile {
	
//	private String window;
//	private String door;
//	private int noAC;
//	private int AC;
//	private int indoor;
//	private int outdoor;
//	private Double horizontal;
//	private Double vertical;
//	private int windows;
//	private int doors;
		
		/**
		 * Constructor takes in values, then immediately calls saveFile() to put items into saveFile
		 * @param window - Type of window
		 * @param door -  Type of door
		 * @param noAC - Bill without AC
		 * @param AC - Bill with Ac
		 * @param indoor - Temperature wanted inside
		 * @param outdoor - Temperature outside
		 * @param horizontal - Length of floor for X value
		 * @param vertical - Width of floor for Y value
		 * @param windows - Number of windows
		 * @param doors - Number of doors
		 */
	public SaveFile() {
//		this.window = null;
//		this.door = null;
//		this.noAC = 0;
//		this.AC = 0;
//		this.indoor = 0;
//		this.outdoor =  0;
//		this.horizontal = 0.0;
//		this.vertical = 0.0;
//		this.windows = 0;
//		this.doors = 0;
	}
	
	
	public void newSave(String window, String door, String noAC, String AC, String indoor, String outdoor, double horizontal, double vertical, String windows, String doors) {
//		this.window = window;
//		this.door = door;
//		this.noAC = Double(noAC).intValue();
//		this.AC = AC;
//		this.indoor = indoor;
//		this.outdoor =  outdoor;
//		this.horizontal = horizontal;
//		this.vertical = vertical;
//		this.windows = windows;
//		this.doors = doors;
		try {
			File sf = new File("ESCsaveFile.txt");
			PrintStream saveFile = new PrintStream(sf);
			saveFile.println(window);
			saveFile.println(door);
			saveFile.println(Integer.parseInt(noAC));
			saveFile.println(Integer.parseInt(AC));
			saveFile.println(Integer.parseInt(indoor));
			saveFile.println(Integer.parseInt(outdoor));
			saveFile.println(horizontal);
			saveFile.println(vertical);
			saveFile.println(Integer.parseInt(windows));
			saveFile.println(Integer.parseInt(doors));
			saveFile.close();
		} catch (FileNotFoundException ee) {
			System.out.println("ESCsaveFile.txt was moved");
		}
	}
}
