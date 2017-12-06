package com.unknown8.esc.model;

import java.io.File;

public class Directory {

	public Directory() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * makes "Calculator Projects" directory for save files if directory doesn't exist
	 * @param args
	 */
	public void CreateDirectory() {
		File dir = new File("Calculator Projects");
		if(dir.exists()) {
			if(dir.isDirectory()) {
				assert true;		//does nothing
			}else { 
				dir.mkdir();
			}
		}
		else if(!dir.exists()) {
			dir.mkdir();
		}

	}
	
}
