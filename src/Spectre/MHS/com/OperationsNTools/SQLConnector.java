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
            String url = "jdbc:mysql://localhost:3306/mhs?useTimezone=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String sql) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
    }
}
