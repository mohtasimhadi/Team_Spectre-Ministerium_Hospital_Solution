package Spectre.MHS.com;

import java.sql.*;

public class SQLConnector {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mhs?useTimezone=true&serverTimezone=UTC","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
