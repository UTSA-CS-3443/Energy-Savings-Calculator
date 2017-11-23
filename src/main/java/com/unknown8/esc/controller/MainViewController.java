package com.unknown8.esc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.unknown8.esc.model.Calculations;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
	private TextField extWallLengthX;
	@FXML
	private TextField extWallLengthY;
	@FXML
	private TextField numWindows;
	@FXML
	private ComboBox<String> windowType;
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
	private TextField out5y;
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
	@FXML
	Button clear;
	@FXML
	private MenuItem Save;
	@FXML
	private MenuItem SaveAs;
	private int SaveCount=0;

	@FXML
	private Canvas houseLayout;

	private GraphicsContext gc;

	private String typeWindow, typeDoor;
	private double woAC, wAC, inTemp, outTemp, wallLengthX, wallLengthY;
	private int numWin, numDoor;

	private Calculations calc;

	public MainViewController() {
		super();
		this.calc = new Calculations();
	}

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
			wallLengthX = Double.parseDouble(extWallLengthX.getText());
			wallLengthY = Double.parseDouble(extWallLengthY.getText());
			numWin = Integer.parseInt(numWindows.getText());
			numDoor = Integer.parseInt(numDoors.getText());
			typeWindow = windowType.getValue();
			typeDoor = doorType.getValue();
			if (typeWindow == "Type" || typeDoor == "Type") {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fill In Everything");
				alert.setHeaderText(null);
				alert.setContentText("Fill in every box and make selections!");
				alert.showAndWait();
				return;
			}
			if (woAC <= 0 || wAC <= 0) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Input A Valid Bill");
				alert.setHeaderText(null);
				alert.setContentText("Input a bill greater than 0!");
				alert.showAndWait();
				return;
			}
			if (numWin < 0 || numWin > 20) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Enter a reasonable number of windows!");
				alert.setHeaderText(null);
				alert.setContentText("Please select a number 0 through 20");
				alert.showAndWait();
				return;
			}
			if (numDoor < 1 || numDoor > 10) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Enter a reasonable number of doors!");
				alert.setHeaderText(null);
				alert.setContentText("Please select a number 1 through 10!");
				alert.showAndWait();
				return;

			}
			if (outTemp < -89 || outTemp > 54) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Enter a reasonable temperature!");
				alert.setHeaderText(null);
				alert.setContentText("Please select a temperature between -89 and 54!");
				alert.showAndWait();
				return;
			}

		} catch (Exception e1) {
			System.out.println("Fill in every box.");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fill In Everything");
			alert.setHeaderText(null);
			alert.setContentText("Fill in every box and make selections!");
			alert.showAndWait();
			return;
		}
		out2.setEditable(true);
		out2.setText(String.valueOf(this.calc.getNewBill(wAC, typeWindow, typeDoor)));
		out2.setEditable(false);

		out1.setEditable(true);
		out1.setText(String.valueOf(this.calc.getSavings()));
		out1.setEditable(false);

		out3.setEditable(true);
		out3.setText(String.valueOf(inTemp));
		out3.setEditable(false);

		out4.setEditable(true);
		out4.setText(String.valueOf(outTemp));
		out4.setEditable(false);

		out5.setEditable(true);
		out5.setText(String.valueOf(wallLengthX));
		out5.setEditable(false);

		out5y.setEditable(true);
		out5y.setText(String.valueOf(wallLengthY));
		out5y.setEditable(false);

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

		// Rectangle House = new Rectangle( adgwdgwad);
		drawHouse();

	}

	@FXML
	public void clearFields(ActionEvent e) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, houseLayout.getWidth(), houseLayout.getHeight());
		// Clear the comboBox via initialize
		initialize();
		// Clear stored values
		woAC = wAC = inTemp = outTemp = wallLengthX = wallLengthY = numWin = numDoor = 0;

		numWindows.setText("");
		numDoors.setText("");
		extWallLengthX.setText("");
		extWallLengthY.setText("");
		targetTempC.setText("");
		outdoorTempC.setText("");
		woACBill.setText("");
		wACBill.setText("");

		// Clear the output
		out1.setEditable(true);
		out1.setText("");
		out1.setEditable(false);

		out2.setEditable(true);
		out2.setText("");
		out2.setEditable(false);

		out3.setEditable(true);
		out3.setText("");
		out3.setEditable(false);

		out4.setEditable(true);
		out4.setText("");
		out4.setEditable(false);

		out5.setEditable(true);
		out5.setText("");
		out5.setEditable(false);

		out5y.setEditable(true);
		out5y.setText("");
		out5y.setEditable(false);

		out6.setEditable(true);
		out6.setText("");
		out6.setEditable(false);

		out7.setEditable(true);
		out7.setText("");
		out7.setEditable(false);

		out8.setEditable(true);
		out8.setText("");
		out8.setEditable(false);

		out9.setEditable(true);
		out9.setText("");
		out9.setEditable(false);

	}

	@FXML
	private void save(ActionEvent e) {
		try {
			File sf = new File("ESCsaveFile.txt");
			PrintStream saveFile = new PrintStream(sf);
			saveFile.println(typeWindow);
			saveFile.println(typeDoor);
			saveFile.println(woAC);
			saveFile.println(wAC);
			saveFile.println(inTemp);
			saveFile.println(outTemp);
			saveFile.println(wallLengthX);
			saveFile.println(wallLengthY);
			saveFile.println(numWin);
			saveFile.println(numDoor);
			saveFile.close();
		} catch (FileNotFoundException ee) {
			System.out.println("ESCsaveFile.txt was moved");
		}
	}
	
	@FXML
	private void saveAs(ActionEvent e) {
		try {
			File sf = new File("ESCsaveFile"+SaveCount+".txt");
			PrintStream saveFile = new PrintStream(sf);
			saveFile.println(typeWindow);
			saveFile.println(typeDoor);
			saveFile.println(woAC);
			saveFile.println(wAC);
			saveFile.println(inTemp);
			saveFile.println(outTemp);
			saveFile.println(wallLengthX);
			saveFile.println(wallLengthY);
			saveFile.println(numWin);
			saveFile.println(numDoor);
			saveFile.close();
		} catch (FileNotFoundException ee) {
			System.out.println("ESCsaveFile"+SaveCount+".txt was moved");
		}
	}

	private void drawHouse() {
		gc = houseLayout.getGraphicsContext2D();
		gc.setLineWidth(1.0);
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, houseLayout.getWidth(), houseLayout.getHeight());
		gc.setFill(Color.CYAN);
		gc.fillRect( (houseLayout.getWidth()/2) - (wallLengthX/2), (houseLayout.getHeight()/2) - (wallLengthY()/2), wallLengthX, wallLengthY);
		//gc.fillRect(houseLayout.getWidth() / 4, houseLayout.getHeight() / 4, wallLengthX, wallLengthY);
	}

}
