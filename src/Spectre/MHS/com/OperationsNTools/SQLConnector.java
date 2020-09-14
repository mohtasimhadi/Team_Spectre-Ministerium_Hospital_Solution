package Spectre.MHS.com.OperationsNTools;

import java.sql.*;

public class SQLConnector {
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    public Statement statement;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mhs?useTimezone=true&serverTimezone=UTC","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
