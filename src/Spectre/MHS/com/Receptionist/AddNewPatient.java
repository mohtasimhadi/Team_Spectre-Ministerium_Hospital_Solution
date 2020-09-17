package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Lists.DoctorList;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import Spectre.MHS.com.UserProfile.ReceptionistRange;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

public class AddNewPatient {
    private JPanel contentPanel;
    private JButton backButton;
    private JComboBox<String> gender, bloodGroup;
    private JButton addPatientButton, viewDoctors;
    private JTextField name, age, contactNo, email, appointedDoctor;
    private DatePicker dateOfAdmission, dateOfAppointment, dateOfRelease;

    private final String userid;
    private final Display display = new Display("Add New Patient", contentPanel);

    public AddNewPatient(String userid) {
        this.userid = userid;
        appointedDoctor.setEditable(false);

        backButton.addActionListener(e -> onBack());
        addPatientButton.addActionListener(e -> onAddPatient());
        viewDoctors.addActionListener(e -> onViewDoctors());
        display.displayOn();
    }

    private void onViewDoctors(){
        new DoctorList(appointedDoctor);
    }

    private void onAddPatient(){
        if(name.getText().equals(""))
            JOptionPane.showMessageDialog(contentPanel, "Input Data Correctly");
        else{

            SQLConnector sqlConnector = new SQLConnector();
            String sql = "INSERT INTO patient (Name, Age, Gender, DateOfAdmission, DateOfAppointment, AppointedDoctor, DateOfRelease, ContactNo, Email, BloodGroup) values (?,?,?,?,?,?,?,?,?,?)";
            try {
                String[] parameters = new String[10];
                parameters[0] = name.getText();
                parameters[1] = age.getText();
                parameters[2] = Objects.requireNonNull(gender.getSelectedItem()).toString();
                parameters[3] = dateOfAdmission.getText();
                parameters[4] = dateOfAppointment.getText();
                parameters[5] = appointedDoctor.getText();
                parameters[6] = dateOfRelease.getText();
                parameters[7] = contactNo.getText();
                parameters[8] = email.getText();
                parameters[9] = Objects.requireNonNull(bloodGroup.getSelectedItem()).toString();

                sqlConnector.executeUpdate(parameters, sql, 10);

                sql = "SELECT MAX(ID) FROM patient";
                sqlConnector.executeQuery(sql, true);
                JOptionPane.showMessageDialog(contentPanel, "Patient Inserted with ID " + sqlConnector.resultSet.getInt(1));
                new AddNewPatient(userid);
                display.displayOff();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void onBack(){
        new ReceptionistRange(userid);
        display.displayOff();
    }
}
