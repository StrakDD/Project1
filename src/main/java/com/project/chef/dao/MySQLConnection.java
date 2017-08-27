package com.project.chef.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Denis Starovoitenko on 25.08.2017.
 */
public class MySQLConnection {

    public static Connection getMySQLConnection(){
        String hostName = "localhost";
        String dbName = "chef";
        String userName = "root";
        String passWord = "root";
        return getMySQLConnection(hostName, dbName, userName, passWord);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String passWord) {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName
                                + "?autoReconnect=true&useSSL=false";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
