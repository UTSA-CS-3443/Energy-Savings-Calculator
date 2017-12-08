package com.unknown8.esc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;


public class SaveFileAs {

	public SaveFileAs() {
		// TODO Auto-generated constructor stub
	}
	
	public void  newSFA(String title, String window, String door, String noAC, String AC, String indoor, String outdoor, double horizontal, double vertical, String windows, String doors) {
		try {
			if(title == null || title == "") {
				title = "ESCsaveFile";
			}
			File sf = new File(System.getProperty("user.dir")+"/Calculator Projects/"+title+".txt");
			if(!sf.exists()) {
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
			}
			
		} catch (FileNotFoundException ee) {
			System.out.println(title+".txt was moved");
		}

	}
}
