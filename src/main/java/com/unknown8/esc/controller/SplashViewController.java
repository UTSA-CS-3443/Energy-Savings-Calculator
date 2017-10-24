package com.unknown8.esc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.unknown8.esc.Main;

public class SplashViewController {

	@FXML
	private JFXButton newButton;
	@FXML
	private JFXButton openButton;

	private Stage primaryStage;

	@FXML
	private void handleNewButton(ActionEvent e) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainView.fxml"));
			Main.stage.setScene(new Scene(root));
			Main.stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	private void handleOpenButton(ActionEvent e) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose existing floorplan");
		chooser.showOpenDialog(primaryStage);
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
