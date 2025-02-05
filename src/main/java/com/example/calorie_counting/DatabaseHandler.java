package com.example.calorie_counting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection()
            throws SQLException, ClassNotFoundException{
        String conectString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName  + "?"
                + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(conectString, dbUser, dbPass);

        return dbConnection;
    }

    public void writUserSQL(String log, String pass, String gender, String weight, String height, String age) {
        String insert = "INSERT INTO " + Const.USER_NAME +
                " VALUES (?, ?, ?, ?, ?, ?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, age);
            prSt.setString(2, height);
            prSt.setString(3, weight);
            prSt.setString(4, gender);
            prSt.setString(5, log);
            prSt.setString(6, pass);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void ReadUserSQL(String log, String pass, String gender, String weight, String height, String age){
        String select = "SELECT "+ Const.USER_AGE + ", " +Const.USER_HEIGHT + ", "+ Const.USER_WEIGHT + ", "+ Const.USER_GENDER + ", " + Const.USER_LOGIN + ", " + Const.USER_PASSWORD +
                " FROM " + Const.USER_NAME;

    }

}
