package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import javax.naming.Name;
import javax.swing.*;

import java.sql.SQLException;
import java.util.Objects;

public class AddNewPatient {
    private JPanel contentPanel;
    private JButton backButton;
    private JButton addPatientButton;
    private JComboBox jGender;
    private JComboBox jBloodGroup;
    private JTextField jName;
    private JTextField jAge;
    private JTextField jDateOfAdmission;
    private JTextField jDateOfAppointment;
    private JTextField jDateOfRelease;
    private JTextField jContactNo;
    private JTextField jEmail;
    private JTextField jAppointedDoctor;
    private JButton jViewDoctors;
    private final String userid;
    private final Display display = new Display("Add New Patient", contentPanel);

    public AddNewPatient(String userid) {
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> onBack());

        addPatientButton.addActionListener(e -> {
            if(jName.getText().equals(""))
                JOptionPane.showMessageDialog(contentPanel, "Input Data Correctly");
            else
                onAddPatient();
        });
    }

    void onAddPatient(){
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();
        String sql = "INSERT INTO patient (Name, Age, Gender, DateOfAdmission, DateOfAppointment, AppointedDoctor, DateOfRelease, ContactNo, Email, BloodGroup) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
            sqlConnector.preparedStatement.setString(1, jName.getText());
            sqlConnector.preparedStatement.setString(2, jAge.getText());
            sqlConnector.preparedStatement.setString(3, Objects.requireNonNull(jGender.getSelectedItem()).toString());
            sqlConnector.preparedStatement.setString(4, jDateOfAdmission.getText());
            sqlConnector.preparedStatement.setString(5, jDateOfAppointment.getText());
            sqlConnector.preparedStatement.setString(6, jAppointedDoctor.getText());
            sqlConnector.preparedStatement.setString(7, jDateOfRelease.getText());
            sqlConnector.preparedStatement.setString(8, jContactNo.getText());
            sqlConnector.preparedStatement.setString(9, jEmail.getText());
            sqlConnector.preparedStatement.setString(10, Objects.requireNonNull(jBloodGroup.getSelectedItem()).toString());

            sqlConnector.preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(contentPanel, "Patient Inserted");

            jName.setText("");
            jAge.setText("");
            jGender.setSelectedIndex(-1);
            jDateOfAdmission.setText("");
            jDateOfAppointment.setText("");
            jAppointedDoctor.setText("");
            jDateOfRelease.setText("");
            jContactNo.setText("");
            jBloodGroup.setSelectedIndex(-1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void onBack(){
        new ReceptionistRange(userid);
        display.displayOff();
    }
}
