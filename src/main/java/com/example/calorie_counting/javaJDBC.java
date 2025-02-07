package com.example.calorie_counting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class javaJDBC extends Config{

    public static void writeDB(User user){

        String insert = "INSERT INTO " + Const.USER_NAME + "(" +
                Const.USER_AGE + "," +Const.USER_HEIGHT + ","+ Const.USER_WEIGHT + ","+ Const.USER_GENDER + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                " VALUES" + "(?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)){
            PreparedStatement prSt = con.prepareStatement(insert);

            prSt.setString(1, user.getAge());
            prSt.setString(2, user.getHeight());
            prSt.setString(3, user.getWeight());
            prSt.setString(4, user.getGender());
            prSt.setString(5, user.getLog());
            prSt.setString(6, user.getPass());

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet ReadUserSQL(User user){
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.USER_NAME +
                " WHERE login =? AND pass =?";
        try(Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)){
            PreparedStatement prst = con.prepareStatement(select);
            prst.setString(1, user.getLog());
            prst.setString(2, user.getPass());
            rs = prst.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

}
