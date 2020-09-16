package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.DoctorList;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

public class AddNewPatient {
    private JPanel contentPanel;
    private JButton backButton;
    private JComboBox gender, bloodGroup;
    private JButton addPatientButton, viewDoctors;
    private JTextField name, age, dateOfAdmission, dateOfAppointment,
            dateOfRelease, contactNo, email, appointedDoctor;

    private final String userid;
    private final Display display = new Display("Add New Patient", contentPanel);

    public AddNewPatient(String userid) {
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> onBack());
        addPatientButton.addActionListener(e -> onAddPatient());
        viewDoctors.addActionListener(e -> onViewDoctors());
    }

    void onViewDoctors(){
        new DoctorList();
    }

    void onAddPatient(){
        if(name.getText().equals(""))
            JOptionPane.showMessageDialog(contentPanel, "Input Data Correctly");
        else{

            SQLConnector sqlConnector = new SQLConnector();
            sqlConnector.connect();
            String sql = "INSERT INTO patient (Name, Age, Gender, DateOfAdmission, DateOfAppointment, AppointedDoctor, DateOfRelease, ContactNo, Email, BloodGroup) values (?,?,?,?,?,?,?,?,?,?)";
            try {
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.preparedStatement.setString(1, name.getText());
                sqlConnector.preparedStatement.setString(2, age.getText());
                sqlConnector.preparedStatement.setString(3, Objects.requireNonNull(gender.getSelectedItem()).toString());
                sqlConnector.preparedStatement.setString(4, dateOfAdmission.getText());
                sqlConnector.preparedStatement.setString(5, dateOfAppointment.getText());
                sqlConnector.preparedStatement.setString(6, appointedDoctor.getText());
                sqlConnector.preparedStatement.setString(7, dateOfRelease.getText());
                sqlConnector.preparedStatement.setString(8, contactNo.getText());
                sqlConnector.preparedStatement.setString(9, email.getText());
                sqlConnector.preparedStatement.setString(10, Objects.requireNonNull(bloodGroup.getSelectedItem()).toString());

                sqlConnector.preparedStatement.executeUpdate();

                sql = "SELECT MAX(ID) FROM patient";
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                sqlConnector.resultSet.next();

                JOptionPane.showMessageDialog(contentPanel, "Patient Inserted with ID " + sqlConnector.resultSet.getInt(1));

                name.setText("");
                age.setText("");
                gender.setSelectedIndex(-1);
                dateOfAdmission.setText("");
                dateOfAppointment.setText("");
                appointedDoctor.setText("");
                dateOfRelease.setText("");
                contactNo.setText("");
                bloodGroup.setSelectedIndex(-1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void onBack(){
        new ReceptionistRange(userid);
        display.displayOff();
    }
}
