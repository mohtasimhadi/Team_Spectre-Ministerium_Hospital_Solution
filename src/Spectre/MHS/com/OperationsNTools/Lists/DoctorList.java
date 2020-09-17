package Spectre.MHS.com.OperationsNTools.Lists;

import Spectre.MHS.com.OperationsNTools.Display;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DoctorList extends AbstractList{
    public DoctorList(JTextField field){
        connectSQL();
        setQuery("SELECT ID, NAME, DESIGNATION FROM DOCTOR");

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        String[][] data = getStringData(sqlConnector.resultSet);
        String[] columnNames = {"ID", "Name", "Designation"};
        table = new JTable(data, columnNames);
        contentPanel = new JScrollPane(table);
        display = new Display("Doctor's List", contentPanel);
        display.changeSize(300, 300);
        addMouseListener(field);
    }
}
