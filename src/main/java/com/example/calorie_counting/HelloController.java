package com.example.calorie_counting;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Login;

    @FXML
    private Button Register;

    @FXML
    private TextField TextLogin;

    @FXML
    private TextField TextRegister;

    @FXML
    void initialize() {
        Login.setOnAction(event -> {
            String log = TextLogin.getText().trim();
            String pass = TextRegister.getText().trim();

            if(!log.equals("") && !pass.equals("")){
                loginUser(log, pass);
            }
            else System.out.println("Error");
        });

        Register.setOnAction(event -> {
            openNewWind("/com/example/calorie_counting/windowsSecond.fxml");
        });

    }

    private void loginUser(String log, String pass) {
        User user = User.getInstance();
        user.setLog(log);
        user.setPass(pass);
        ResultSet rs = javaJDBC.ReadUserSQL(user);

        try {
            if(rs.next()){
                openNewWind("/com/example/calorie_counting/main.fxml");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void openNewWind(String path){
        Register.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
