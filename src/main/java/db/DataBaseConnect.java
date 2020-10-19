package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnect {
    //connect settings
    static final String DB_URL = "jdbc:mysql://192.168.14.73:3306/challange?useUnicode=true&serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";


    public static Connection connectionDataBase() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load MySQL Driver");
            e.printStackTrace();
        }
        System.out.println("MySQL JDBC Driver successfully connected");
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("YOU SUCCESSFULLY CONNECTED TO DATABASE");
        } else {
            System.out.println("FAILED CONNECTION TO DATABASE");
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void createTableUserDataBase(String createTable){

        try{
            Statement statement = connectionDataBase().createStatement();
            statement.execute(createTable);
            System.out.println("TABLE WAS CREATED");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updateTableUserDataBase(String insert){
        try {
            Statement statement = connectionDataBase().createStatement();
            statement.executeUpdate(insert);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
