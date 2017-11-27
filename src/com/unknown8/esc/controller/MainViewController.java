package com.unknown8.esc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import com.unknown8.esc.model.Calculations;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MainViewController implements EventHandler<ActionEvent> {
	@FXML
	private JFXTextField woACBill;
	@FXML
	private JFXTextField wACBill;
	@FXML
	private JFXTextField targetTempC;
	@FXML
	private JFXTextField outdoorTempC;
	@FXML
	private JFXTextField extWallLengthX;
	@FXML
	private JFXTextField extWallLengthY;
	@FXML
	private JFXTextField numWindows;
	@FXML
	private JFXComboBox<String> windowType;
	@FXML
	private JFXTextField numDoors;
	@FXML
	private JFXComboBox<String> doorType;

	@FXML
	private JFXTextField out1;
	@FXML
	private JFXTextField out2;
	@FXML
	private JFXTextField out3;
	@FXML
	private JFXTextField out4;
	@FXML
	private JFXTextField out5;
	@FXML
	private JFXTextField out5y;
	@FXML
	private JFXTextField out6;
	@FXML
	private JFXTextField out7;
	@FXML
	private JFXTextField out8;
	@FXML
	private JFXTextField out9;

	@FXML
	JFXButton confirm;
	@FXML
	JFXButton clear;
	@FXML
	private MenuItem Save;
	@FXML
	private MenuItem SaveAs;
	@FXML
	private MenuItem New;
	private int SaveCount = 0;

	@FXML
	private Canvas houseLayout;

	private GraphicsContext gc;

	private String typeWindow, typeDoor;
	private double woAC, wAC, inTemp, outTemp, wallLengthX, wallLengthY;
	private int numWin, numDoor;
	private ArrayList<Double> cornersX;
	private ArrayList<Double> cornersY;

	private Calculations calc;

	public MainViewController() {
		super();
		this.calc = new Calculations();
	}

	@FXML
	public void initialize() {
		windowType.getItems().clear();
		windowType.getItems().addAll("Single pane", "Double Pane", "Triple Pane");

		doorType.getItems().clear();
		doorType.getItems().addAll("Particle board", "Hardwood");

		drawHouse();
		cornersX = new ArrayList<Double>();
		cornersY = new ArrayList<Double>();
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
			if (typeWindow == null || typeDoor == null) {

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
		// drawHouse();

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
			File sf = new File("ESCsaveFile" + SaveCount + ".txt");
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
			System.out.println("ESCsaveFile" + SaveCount + ".txt was moved");
		}
	}

	private void drawHouse() {
		gc = houseLayout.getGraphicsContext2D();
		// gc.setLineWidth(1.0);
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, houseLayout.getWidth(), houseLayout.getHeight());
		// gc.setFill(Color.CYAN);
		// gc.fillRect( (houseLayout.getWidth()/2) - (wallLengthX/2),
		// (houseLayout.getHeight()/2) - (wallLengthY/2), wallLengthX, wallLengthY);
		// gc.fillRect(houseLayout.getWidth() / 4, houseLayout.getHeight() / 4,
		// wallLengthX, wallLengthY);
		houseLayout.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				gc.beginPath();
				// gc.moveTo(event.getX(), event.getY());
				// gc.stroke();
				cornersX.add(event.getX());
				cornersY.add(event.getY());
				if (cornersX.size() > 1) {
				gc.strokeLine(cornersX.get(cornersX.size() - 1), cornersY.get(cornersY.size() - 1),
						cornersX.get(cornersX.size() - 2), cornersY.get(cornersY.size() - 2));
				
				double xMax = Collections.max(cornersX);
				double yMax = Collections.max(cornersY);
				double xMin = Collections.min(cornersX);
				double yMin = Collections.min(cornersY);
				double xSize = xMax - xMin;
				double ySize = yMax - yMin;
				
				extWallLengthX.setText(String.valueOf(xSize));
				extWallLengthY.setText(String.valueOf(ySize));
				}
			}
		});
	}
}
