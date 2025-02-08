package com.example.calorie_counting;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<?, ?> Chart;

    @FXML
    private Button add;

    @FXML
    private TextField calorie;

    @FXML
    private Label calories_per_day;

    @FXML
    private TextField ead;

    @FXML
    private Label user_name;

    XYChart.Series series = new XYChart.Series();

    @FXML
    void initialize() {
        Eat eat = new Eat();
        int idUser = 1;
        eat.setIduser(idUser);

        drawChart(eat);
        Chart.getData().add(series);

        add.setOnAction(event -> {
            addEat();

            drawChart(eat);
            Chart.getData().add(series);

        });
    }

    private void drawChart(Eat eat) {
        ArrayList<Eat> eatArr = new ArrayList<>();
        ResultSet rs = javaJDBC.ReadData(eat);
        while (true) {
            try {
                if (!rs.next()) break;
                else{
                    int calor = rs.getInt("calories");
                    Date date = rs.getDate("datas");

                    Eat e =  new Eat();
                    e.setCalories(calor);
                    e.setDate(date);

                    eatArr.add(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        ArrayList<Eat> newEatArr = new ArrayList<>(eatArr);
        for(int i = 0; i < newEatArr.size(); i++){
            for(Eat j : eatArr){
                if(newEatArr.get(i).getDate().equals(j.getDate()) && newEatArr.get(i) != j){
                    newEatArr.get(i).sumCalories(j.getCalories());
                    newEatArr.remove(j);
                }
            }
        }

        ObservableList<XYChart.Data> data1 = FXCollections.observableArrayList();
        for(Eat i : newEatArr){
            data1.add(new XYChart.Data(String.valueOf(i.getDate()), i.getCalories()));

        }
        series.setData(data1);

    }

    private void addEat() {
        String eat = ead.getText();
        int cal = Integer.parseInt(calorie.getText());
        int idUser = 1;

        Eat food = new Eat(idUser, eat, cal);
        javaJDBC.insertData(food);
    }

}
