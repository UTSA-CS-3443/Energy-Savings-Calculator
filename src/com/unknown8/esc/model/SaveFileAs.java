package com.unknown8.esc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import com.unknown8.esc.Main;
import com.unknown8.esc.controller.MainViewController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

public class SaveFileAs {

	public SaveFileAs() {
		// TODO Auto-generated constructor stub
	}
	
	public void  newSFA(String window, String door, String noAC, String AC, String indoor, String outdoor, double horizontal, double vertical, String windows, String doors) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Save file as...");
		chooser.setInitialDirectory(new File(System.getProperty("user.dir")+"/Calculator Projects"));
		File open = chooser.showSaveDialog(Main.stage);
		SaveFileOpener parse = new SaveFileOpener(open);
		try {
			File sf = new File(System.getProperty("user.dir")+"/Calculator Projects/ESCsaveFile.txt");
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
