package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Lists.PatientList;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.EmployeeInfo;
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
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email,
                designation, contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> onLogOut());
        patientInformationButton.addActionListener(e -> onPatientInformation());
        changePasswordButton.addActionListener(e -> new PasswordChanger("doctor", userID.getText()));
        viewAppointmentsButton.addActionListener(e -> new PatientList(userID.getText()));
    }

    void onPatientInformation(){
        display.displayOff();
        new PatientInformationDoctor(userid);
    }

    void onLogOut(){
        display.displayOff();
        new DoctorLogin();
    }
}