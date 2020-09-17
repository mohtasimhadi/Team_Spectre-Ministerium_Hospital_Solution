package Spectre.MHS.com.Tools.Lists;

import Spectre.MHS.com.Tools.Display;
import javax.swing.*;
import java.sql.SQLException;

public class PatientList extends AbstractList{
    public PatientList(String DoctorID){
        connectSQL();

        setQuery("SELECT Patient.ID, Patient.Name, Patient.DateOfAppointment " +
                 "FROM Patient, Doctor " +
                 "WHERE Patient.AppointedDoctor = " + DoctorID + " GROUP BY Patient.ID");

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        String[][] data = getStringData(sqlConnector.resultSet);
        String[] columnNames = {"ID", "Name", "Appointment Date"};
        table = new JTable(data, columnNames);
        contentPanel = new JScrollPane(table);
        display = new Display("Doctor's List", contentPanel);
        display.displayDialogueBox(300, 500);
    }
}
