package com.unknown8.esc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.unknown8.esc.Main;
import com.unknown8.esc.model.Calculations;
import com.unknown8.esc.model.Directory;
import com.unknown8.esc.model.SaveFile;
import com.unknown8.esc.model.SaveFileOpener;
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
import javafx.stage.FileChooser;

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
	@FXML
	private MenuItem Open;
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
	private Directory dir;
	private SaveFile create;
	
	private boolean open = false;
	
	public MainViewController() {
		super();
		this.calc = new Calculations();
	}

	@FXML
	public void initialize() {
		dir = new Directory();
		dir.CreateDirectory();
		windowType.getItems().clear();
		windowType.getItems().addAll("SinglePane", "DoublePane", "TriplePane");

		doorType.getItems().clear();
		doorType.getItems().addAll("ParticleBoard", "Hardwood");

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
			System.out.println(e1);
			System.out.println("Fill in every box.");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fill In Everything");
			alert.setHeaderText(null);
			alert.setContentText("Fill in every box and make selections so calculations can be made!");
			alert.showAndWait();
			return;
		}
		out2.setEditable(true);
		out2.setText(String.valueOf(this.calc.getNewBill(wAC, woAC, typeWindow, typeDoor)));
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

		if(open ==  true) {
			autoDrawHouse();
			open = false;
		}
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
		create = new SaveFile();
		create.newSave(typeWindow, typeDoor, woACBill.getText(), wACBill.getText(), targetTempC.getText(), 
				outdoorTempC.getText(), Double.parseDouble(extWallLengthX.getText()), Double.parseDouble(extWallLengthY.getText()), numWindows.getText(), numDoors.getText());
		
//		try {
//			File sf = new File("ESCsaveFile.txt");
//			PrintStream saveFile = new PrintStream(sf);
//			saveFile.println(typeWindow);
//			saveFile.println(typeDoor);
//			saveFile.println(woAC);
//			saveFile.println(wAC);
//			saveFile.println(inTemp);
//			saveFile.println(outTemp);
//			saveFile.println(wallLengthX);
//			saveFile.println(wallLengthY);
//			saveFile.println(numWin);
//			saveFile.println(numDoor);
//			saveFile.close();
//		} catch (FileNotFoundException ee) {
//			System.out.println("ESCsaveFile.txt was moved");
//		}
	}

	@FXML
	private void saveAs(ActionEvent e) {
		
//		try {
//			File sf = new File("ESCsaveFile" + SaveCount + ".txt");
//			PrintStream saveFile = new PrintStream(sf);
//			saveFile.println(typeWindow);
//			saveFile.println(typeDoor);
//			saveFile.println(woAC);
//			saveFile.println(wAC);
//			saveFile.println(inTemp);
//			saveFile.println(outTemp);
//			saveFile.println(wallLengthX);
//			saveFile.println(wallLengthY);
//			saveFile.println(numWin);
//			saveFile.println(numDoor);
//			saveFile.close();
//		} catch (FileNotFoundException ee) {
//			System.out.println("ESCsaveFile" + SaveCount + ".txt was moved");
//		}
	}
	
	/**
	 * for opening file
	 * @param allData 
	 */
	@FXML
	private void setData2() {
		open = true;
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose existing floorplan");
		chooser.setInitialDirectory(new File("."));
		File open = chooser.showOpenDialog(Main.stage);
		SaveFileOpener parse = new SaveFileOpener(open);
		ArrayList<String> retrieve = parse.getTypes();
			// windowType.setValue( retrieve.get(0) );
		windowType.setValue( retrieve.get(0));
		doorType.setValue( retrieve.get(1) );
		woACBill.setText(  (retrieve.get(2)) );
		wACBill.setText(retrieve.get(3));
		targetTempC.setText( (retrieve.get(4)) );
		outdoorTempC.setText( (retrieve.get(5)) );
		extWallLengthX.setText( (retrieve.get(6)) );
		extWallLengthY.setText(  (retrieve.get(7)) );
		numWindows.setText( (retrieve.get(8)) );
		numDoors.setText( (retrieve.get(9)) );
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Open succesfull");
		alert.setHeaderText(null);
		alert.setContentText("Press confirm to auto-create a drawing of your floor dimensions.");
		alert.showAndWait();
		autoDrawHouse();
		autoDrawHouse();
	}
	
	private void autoDrawHouse() {
		gc = houseLayout.getGraphicsContext2D();
		gc.setLineWidth(1.0);
 
		gc.setFill(Color.CYAN);
		gc.fillRect( (houseLayout.getWidth()/2) - (wallLengthX/2),(houseLayout.getHeight()/2) - (wallLengthY/2), wallLengthX, wallLengthY);
		//gc.fillRect(houseLayout.getWidth() / 4, houseLayout.getHeight() / 4, wallLengthX, wallLengthY);
	}
	
	/**
	 * to be used in conjuntion with SplashViewController, 
	 * @param allData
	 */
	public void setData(ArrayList<String> allData) {
		open = true;
//		
//		if(allData.get(0) == "SinglePane") {
//			windowType.getSelectionModel().select(0);
//		} else if(allData.get(0) == "DoublePane") {
//			windowType.getSelectionModel().select(1);
//		} else if (allData.get(0) == "TriplePane"){
//			windowType.getSelectionModel().select(2);
//		} else {
//			typeWindow = null;
//		}
//		
//		if(allData.get(1) == "ParticleBoard") {
//			doorType.getSelectionModel().select(0);
//		} else if(allData.get(1) == "Hardwood") {
//			doorType.getSelectionModel().select(1);
//		} else {
//			typeDoor = null;
//		}
		//doorType.getSelectionModel().select(0);
	//	woACBill.setText( (allData.get(3)) );
				//allData.get(0)); 
		windowType.setValue( allData.get(0));
		doorType.setValue( allData.get(1) );
		woACBill.setText(  (allData.get(2)) );
		wACBill.setText(allData.get(3));
		targetTempC.setText( (allData.get(4)) );
		outdoorTempC.setText( (allData.get(5)) );
		extWallLengthX.setText( (allData.get(6)) );
		extWallLengthY.setText(  (allData.get(7)) );
		numWindows.setText( (allData.get(8) ));
		numDoors.setText( (allData.get(9)) );
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Open succesfull");
		alert.setHeaderText(null);
		alert.setContentText("Press confirm to auto-create a drawing of your floor dimensions.");
		alert.showAndWait();
		autoDrawHouse();
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
