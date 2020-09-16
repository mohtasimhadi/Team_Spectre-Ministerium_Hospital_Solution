package Spectre.MHS.com.OperationsNTools;

import java.sql.SQLException;

public class LogIn {
    SQLConnector sqlConnector = new SQLConnector();
    public String userTypeFound;
    public boolean onLogIn(String query, String userid, String password){
        sqlConnector.connect();

        try{
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2,password);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                userTypeFound = sqlConnector.resultSet.getString("Designation");
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}