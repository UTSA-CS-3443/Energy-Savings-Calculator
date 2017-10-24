package com.unknown8.esc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController implements EventHandler<ActionEvent> {
	@FXML
	private TextField woACBill;
	@FXML
	private TextField wACBill;
	@FXML
	private TextField targetTempC;
	@FXML
	private TextField outdoorTempC;
	@FXML
	private TextField extWallLength;

	@FXML
	private TextField out1;
	@FXML
	private TextField out2;
	@FXML
	private TextField out3;
	@FXML
	private TextField out4;

	@FXML
	Button confirm;
	
	private double woAC, wAC, inTemp, outTemp;

	@Override
	public void handle(ActionEvent e) {
	
		try {
		woAC = Double.parseDouble(woACBill.getText());
		wAC = Double.parseDouble(wACBill.getText());
		inTemp = Double.parseDouble(targetTempC.getText());
		outTemp = Double.parseDouble(outdoorTempC.getText());
		}catch(Exception e1) {
			System.out.println("Fill in all four values with numbers.");
			return;
		}
		out1.setEditable(true);		
		out1.setText(String.valueOf(woAC));
		out1.setEditable(false);	
		
		out2.setEditable(true);		
		out2.setText(String.valueOf(wAC));
		out2.setEditable(false);	
		
		out3.setEditable(true);		
		out3.setText(String.valueOf(inTemp));
		out3.setEditable(false);	
		
		out4.setEditable(true);		
		out4.setText(String.valueOf(outTemp));
		out4.setEditable(false);	

	}
}
