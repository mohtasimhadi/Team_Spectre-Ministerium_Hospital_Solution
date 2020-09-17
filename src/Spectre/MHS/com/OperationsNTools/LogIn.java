package Spectre.MHS.com.OperationsNTools;

import java.sql.SQLException;

public class LogIn {
    SQLConnector sqlConnector = new SQLConnector();
    public String userTypeFound;
    public boolean onLogIn(String query, String userid, String password){

        try{
            String[] parameters = new String[2];
            parameters[0] = userid;
            parameters[1] = password;
            sqlConnector.executeQuery(parameters, query, 2);
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