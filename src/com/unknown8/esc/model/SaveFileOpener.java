package com.unknown8.esc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveFileOpener {

	private static ArrayList<String> fileValues = new ArrayList<String>();
		
	public SaveFileOpener (File open) {
		
		Scanner scan = null;
        try {
            scan = new Scanner(open);
            while(scan.hasNext()) {
            	fileValues.add( scan.next() );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open " + open.getName());
        }
        scan.close();
	}
	
	public ArrayList<String> getTypes() {
		return fileValues;
		
	}
	
	/**Test
	 * i was trying to add the first two lines in their own arraylist, then a second arraylist of doubles
	 * was supposed to take the numbers. for some reason, im not able to read it in right, so i threw them in one
	 * arraylist. those textfields should be able to just translate these "Strings" into doubles, anyways**/
    public static void main (String[] args) {
    	File testFile = new File ("ESCsaveFile.txt");
    	SaveFileOpener test =  new SaveFileOpener(testFile);
    	ArrayList<String> testArray = test.getTypes();
    	
    	for (int i = 0; i <testArray.size(); i++) {
    		System.out.println( testArray.get( i) );
    	
    	}
    }
	
}
