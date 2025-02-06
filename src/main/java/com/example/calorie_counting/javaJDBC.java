package com.example.calorie_counting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class javaJDBC{
    public static void writeDB(String log, String pass, String gender, String weight, String height, String age){
        String url = "jdbc:postgresql://localhost:5432/cal";
        String user = "postgres";
        String password = "171015246Mox@";

        String insert = "INSERT INTO " + Const.USER_NAME + "(" +
                Const.USER_AGE + "," +Const.USER_HEIGHT + ","+ Const.USER_WEIGHT + ","+ Const.USER_GENDER + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                " VALUES" + "(?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, user, password)){
            PreparedStatement prSt = con.prepareStatement(insert);

            prSt.setString(1, age);
            prSt.setString(2, height);
            prSt.setString(3, weight);
            prSt.setString(4, gender);
            prSt.setString(5, log);
            prSt.setString(6, pass);

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
