package Spectre.MHS.com.OperationsNTools.Lists;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import javax.swing.*;
import java.sql.SQLException;

public class DoctorList extends AbstractList{
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
}
