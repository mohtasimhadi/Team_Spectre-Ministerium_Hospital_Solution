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

    public void executeQuery(String sql, Boolean resultSetNext) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        if(resultSetNext)
            resultSet.next();
    }

    public void executeQuery(String[] strings, String sql, int size) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i=0; i<size; i++){
            preparedStatement.setString(i+1, strings[i]);
        }
        preparedStatement.executeQuery();
    }

    public void executeUpdate(String[] strings, String sql, int size) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for(int i=0; i<size; i++){
            preparedStatement.setString(i+1, strings[i]);
        }
        preparedStatement.executeUpdate();
    }
}
