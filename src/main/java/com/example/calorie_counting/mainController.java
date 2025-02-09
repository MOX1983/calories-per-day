package com.example.calorie_counting;

import java.awt.event.MouseEvent;
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
import javafx.stage.Stage;

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
    private Label calories_my;

    @FXML
    private Label calories_per_day;

    @FXML
    private TextField ead;

    @FXML
    private Label user_name;

    @FXML
    void initialize() {

        Eat eat = new Eat();
        User user = User.getInstance();
        ResultSet rs = javaJDBC.ReadUserSQL(user);
        while (true) {
            try {
                if (!rs.next()) break;
                else{
                    eat.setIduser(rs.getInt("iduser"));
                    user.setGender(rs.getString("gender"));
                    user.setAge(rs.getInt("age"));
                    user.setHeight(rs.getInt("height"));
                    user.setWeight(rs.getInt("weight"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        calories_my.setText(String.valueOf(sumCalor(eat)));

        user_name.setText(user.getLog());
        if(user.getGender().equals("Ж")){
            double BMR = 655.1 + (9.563 * user.getWeight()) + (1.85 * user.getHeight()) - (4.676 * user.getAge());
            calories_per_day.setText(String.valueOf(BMR));
        }
        else {
            double BMR = 66.47 + (13.75 * user.getWeight()) + (5.003 * user.getHeight()) - (6.755 * user.getAge());
            calories_per_day.setText(String.valueOf(BMR));
        }

        add.setOnAction(event -> {
            addEat();
            calories_my.setText(String.valueOf(sumCalor(eat)));
        });
    }
    public Integer sumCalor(Eat eat){
        ArrayList<Eat> eatArr = new ArrayList<>();
        ResultSet rs = javaJDBC.ReadData(eat);
        while (true) {
            try {
                if (!rs.next()) break;
                else{
                    int calor = rs.getInt("calories");
                    Eat e =  new Eat();
                    e.setCalories(calor);

                    eatArr.add(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int sumC = 0;
        for(Eat e : eatArr){
            sumC += e.getCalories();
        }
        return sumC;
    }

    private void addEat() {
        String eat = ead.getText();
        int cal = Integer.parseInt(calorie.getText());
        int idUser = 1;

        Eat food = new Eat(idUser, eat, cal);
        javaJDBC.insertData(food);
    }

}
