package com.example.calorie_counting;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Register;

    @FXML
    private TextField TextLogin;

    @FXML
    private TextField TextRegister;

    @FXML
    private TextField age;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField height;

    @FXML
    private RadioButton man;

    @FXML
    private TextField weight;

    @FXML
    private RadioButton woman;

    @FXML
    void initialize() {
        Register.setOnAction(event -> {
            logUser();
        });

    }
    public void logUser(){
        RadioButton g = (RadioButton) gender.getSelectedToggle();

        int ageU = Integer.parseInt(age.getText());
        int heightU = Integer.parseInt(height.getText());
        int weightU = Integer.parseInt(weight.getText());
        String genderU = g.getText();
        String logU = TextLogin.getText();
        String passU = TextRegister.getText();

        User user = new User(ageU, heightU, weightU, genderU, logU, passU);
        javaJDBC.writeDB(user);
    }

}
