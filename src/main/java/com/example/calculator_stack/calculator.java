package com.example.calculator_stack;

import controller.calculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       FXMLLoader fxmlLoader = new FXMLLoader(calculator.class.getResource("fXMLcalculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 319, 650);
        calculatorController.stage=stage;

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}