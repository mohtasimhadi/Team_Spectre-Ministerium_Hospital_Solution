package Spectre.MHS.com.Tools.Lists;

import Spectre.MHS.com.Tools.Display;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        addMouseListener(field);
        display.displayDialogueBox(300, 300);
    }

    void addMouseListener(JTextField field){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(field);
            }
        });
        display.displayOff();
    }
    private void onClick(JTextField field){
        int index = table.getSelectedRow();
        field.setText((String) table.getValueAt(index, 0));
        display.displayOff();
    }
}
