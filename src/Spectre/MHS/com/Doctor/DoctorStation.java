package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class DoctorStation {
    private JPanel contentPanel;
    private JButton logOutButton, changePasswordButton, patientInformationButton, viewAppointmentsButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final String userid;
    private final Display display = new Display("Doctors Station", contentPanel);

    public DoctorStation(String userid) {
        this.userid = userid;
        display.displayOn();

        String query = "SELECT * FROM doctor WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email,
                designation, contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> {
            display.displayOff();
            onLogOut();
        });
        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.displayOff();
        });
        changePasswordButton.addActionListener(e -> new PasswordChanger("doctor", userID.getText()));
    }

    void onPatientInformation(){
        new PatientInformationDoctor(userid);
    }

    void onLogOut(){
        new DoctorLogin();
    }
}