package com.unknown8.esc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import com.jfoenix.controls.JFXButton;
import com.unknown8.esc.Main;
import com.unknown8.esc.model.SaveFileOpener;

public class SplashViewController {

	@FXML
	private JFXButton newButton;
	@FXML
	private JFXButton openButton;

	@FXML
	private void handleNewButton(ActionEvent e) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().clear();
			scene.getStylesheets().add(getClass().getResource("./mainView.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	private void handleOpenButton(ActionEvent e) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose existing floorplan");
		chooser.setInitialDirectory(new File("."));
		File open = chooser.showOpenDialog(Main.stage);
		SaveFileOpener parse = new SaveFileOpener(open);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainView.fxml"));
			Parent root = loader.load();
			MainViewController passStuff = loader.getController();
			passStuff.setData(parse.getTypes());
			//Parent root = FXMLLoader.load(getClass().getResource("../view/MainView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().clear();
			scene.getStylesheets().add(getClass().getResource("./mainView.css").toExternalForm());
//			
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
