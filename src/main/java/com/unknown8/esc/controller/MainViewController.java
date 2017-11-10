package com.unknown8.esc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	private TextField numWindows;
	@FXML
	private	ComboBox<String> windowType;
	@FXML
	private TextField numDoors;
	@FXML
	private ComboBox<String> doorType;

	@FXML
	private TextField out1;
	@FXML
	private TextField out2;
	@FXML
	private TextField out3;
	@FXML
	private TextField out4;
	@FXML
	private TextField out5;
	@FXML
	private TextField out6;
	@FXML
	private TextField out7;
	@FXML
	private TextField out8;
	@FXML
	private TextField out9;

	@FXML
	Button confirm;
	
	private String typeWindow, typeDoor;
	private double woAC, wAC, inTemp, outTemp, wallLength;
	private int numWin, numDoor;
	
	@FXML
	public void initialize() {
	    windowType.getItems().clear();
	    windowType.getItems().addAll("Single pane", "Double Pane", "Triple Pane");
	    windowType.getSelectionModel().select("Type");
	    
	    doorType.getItems().clear();
	    doorType.getItems().addAll("Particle board", "Hardwood");
	    doorType.getSelectionModel().select("Type");
	}

	@Override
	public void handle(ActionEvent e) {
	
		try {
		woAC = Double.parseDouble(woACBill.getText());
		wAC = Double.parseDouble(wACBill.getText());
		inTemp = Double.parseDouble(targetTempC.getText());
		outTemp = Double.parseDouble(outdoorTempC.getText());
		wallLength = Double.parseDouble(extWallLength.getText());
		numWin = Integer.parseInt(numWindows.getText());
		numDoor = Integer.parseInt(numDoors.getText());
		typeWindow = windowType.getValue();
		typeDoor = doorType.getValue();
		if (typeWindow == "Type" || typeDoor == "Type") {
			System.out.println("Fill in every box.");
			return;
		}
		}catch(Exception e1) {
			System.out.println("Fill in every box.");
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
		
		out5.setEditable(true);		
		out5.setText(String.valueOf(wallLength));
		out5.setEditable(false);	
		
		out6.setEditable(true);		
		out6.setText(String.valueOf(numWin));
		out6.setEditable(false);	
		
		out7.setEditable(true);		
		out7.setText(String.valueOf(numDoor));
		out7.setEditable(false);	
		
		out8.setEditable(true);		
		out8.setText(typeWindow);
		out8.setEditable(false);	
		
		out9.setEditable(true);		
		out9.setText(typeDoor);
		out9.setEditable(false);	

	}
}
