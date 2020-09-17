package Spectre.MHS.com.Tools;

import java.sql.*;

public class SQLConnector {
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    public Statement statement;

    public SQLConnector(){
        connect();
    }

    private void connect(){
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

    public void executeQuery(String[] parameters, String sql, int size) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i=0; i<size; i++){
            preparedStatement.setString(i+1, parameters[i]);
        }
        resultSet = preparedStatement.executeQuery();
    }

    public void executeUpdate(String sql) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void executeUpdate(String[] parameters, String sql, int size) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for(int i=0; i<size; i++){
            preparedStatement.setString(i+1, parameters[i]);
        }
        preparedStatement.executeUpdate();
    }
}
