package com.example.calorie_counting;

import java.sql.*;
import java.time.LocalDate;

public class javaJDBC extends Config{

    public static void writeDB(User user){

        String insert = "INSERT INTO " + Const.USER_NAME + "(" +
                Const.USER_AGE + "," +Const.USER_HEIGHT + ","+ Const.USER_WEIGHT + ","+ Const.USER_GENDER + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                " VALUES" + "(?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)){
            PreparedStatement prSt = con.prepareStatement(insert);

            prSt.setInt(1, user.getAge());
            prSt.setInt(2, user.getHeight());
            prSt.setInt(3, user.getWeight());
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
    public static void insertData(Eat eat){

        String insert = "INSERT INTO " + Const.EAT_NAME + "(" +
                Const.EAT_USER_ID + "," +Const.EAT + "," + Const.EAT_CAL + ","+ Const.EAT_DATE +")" +
                " VALUES" + "(?,?,?,?)";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)){
            PreparedStatement prSt = con.prepareStatement(insert);

            prSt.setInt(1, eat.getIduser());
            prSt.setString(2, eat.getEat());
            prSt.setInt(3, eat.getCalories());
            prSt.setDate(4, Date.valueOf(LocalDate.now()));

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet ReadData(Eat eat){
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.EAT_NAME +
                " WHERE iduser =? AND datas =? ORDER BY calories";
        try(Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)){
            PreparedStatement prst = con.prepareStatement(select);
            prst.setInt(1, eat.getIduser());
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            rs = prst.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }


}
