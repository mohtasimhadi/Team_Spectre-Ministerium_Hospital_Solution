package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorList {
    SQLConnector sqlConnector;
    Display display;

    public DoctorList(){
        sqlConnector = new SQLConnector();
        sqlConnector.connect();

        String query = "SELECT ID, NAME, DESIGNATION FROM DOCTOR";

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        String[][] data = getStringData(sqlConnector.resultSet);
        String[] columnNames = {"ID", "Name", "Designation"};
        JTable table = new JTable(data, columnNames);
        JScrollPane contentPanel = new JScrollPane(table);
        display = new Display("Doctor's List", contentPanel);
        display.displayOn();
        display.changeSize(300, 300);

    }

    int getNumberOfRows(ResultSet resultSet){
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return i;
    }

    String[][] getStringData(ResultSet resultSet){
        int rows = getNumberOfRows(resultSet);
        String[][] data = new String[rows][3];
        try {
            resultSet.beforeFirst();
            int rowNum = 0;
            while (resultSet.next()){
                String[] eachRow = new String[3];
                for(int i=1; i<=3; i++){
                    eachRow[i-1] = resultSet.getString(i);
                }
                data[rowNum] = eachRow;
                rowNum++;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return data;
    }
}
