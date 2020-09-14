package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class DoctorStation {
    private JPanel contentPanel;
    private JButton logOutButton, addNewEmployeeButton, changePassword, viewEmployeeButton, patientInformationButton, viewAppointmentsButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final String userid;
    private final Display display = new Display("Doctors Station", contentPanel);

    public DoctorStation(String userid) {
        this.userid = userid;
        display.DisplayOn();

        String query = "SELECT * FROM doctor WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email,
                designation, contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> {
            display.DisplayOff();
            onLogOut();
        });
        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.DisplayOff();
        });
    }

    void onPatientInformation(){
        new PatientInformationDoctor(userid);
    }

    void onLogOut(){
        new DoctorLogin();
    }
}