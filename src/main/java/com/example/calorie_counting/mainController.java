package com.example.calorie_counting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private TextField calorie;

    @FXML
    private Label calories_per_day;

    @FXML
    private TextField ead;

    @FXML
    private LineChart<?, ?> grafik;

    @FXML
    void initialize() {

    }

}
