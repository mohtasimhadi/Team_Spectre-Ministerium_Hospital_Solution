package Spectre.MHS.com.OperationsNTools;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import java.sql.SQLException;

public class LogIn {
    SQLConnector sqlConnector = new SQLConnector();

    public boolean onLogIn(String query, String userid, String password){
        sqlConnector.connect();

        try{
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2,password);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
