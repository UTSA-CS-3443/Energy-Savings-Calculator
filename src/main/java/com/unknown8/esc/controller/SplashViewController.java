package com.unknown8.esc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;

public class SplashViewController {
  
  @FXML
  private JFXButton newButton;
  @FXML
  private JFXButton openButton;
  
  private Stage primaryStage;
  
  @FXML
  private void handleNewButton(ActionEvent e) {
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
