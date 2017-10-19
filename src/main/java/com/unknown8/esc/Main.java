package com.unknown8.esc;

import java.io.IOException;

import com.unknown8.esc.controller.SplashViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;
  
	@Override
	public void start(Stage primaryStage) {
	  try {
  	  this.primaryStage = primaryStage;
  	  this.primaryStage.setTitle("Energy Savings Calculator");
  	  
  	  initRootLayout();
  	  
  	  showSplashView();
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}
	
	public void initRootLayout() {
	  try {
  	  FXMLLoader loader = new FXMLLoader();
  	  loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
  	  rootLayout = (BorderPane) loader.load();
  	  
  	  Scene scene = new Scene(rootLayout);
  	  primaryStage.setScene(scene);
  	  primaryStage.show();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}
	
	public void showSplashView() {
	  try {
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(Main.class.getResource("view/SplashView.fxml"));
	    AnchorPane splash = (AnchorPane) loader.load();
	    
	    rootLayout.setCenter(splash);

	    SplashViewController controller = loader.getController();
	    controller.setPrimaryStage(this.primaryStage);
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
