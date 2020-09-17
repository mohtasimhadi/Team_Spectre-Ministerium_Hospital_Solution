package Spectre.MHS.com.UserProfile;

import Spectre.MHS.com.PatientInformation.PatientInformationDoctor;
import Spectre.MHS.com.LogIn.DoctorLogin;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Lists.PatientList;
import Spectre.MHS.com.Operations.PasswordChanger;
import Spectre.MHS.com.Operations.EmployeeInfo;
import javax.swing.*;

public class DoctorStation {
    private JPanel contentPanel;
    private JButton logOutButton, changePasswordButton, patientInformationButton, viewAppointmentsButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final String userid;
    private final Display display = new Display("Doctors Station", contentPanel);

    public DoctorStation(String userid) {
        this.userid = userid;

        String query = "SELECT * FROM doctor WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email,
                designation, contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> onLogOut());
        patientInformationButton.addActionListener(e -> onPatientInformation());
        changePasswordButton.addActionListener(e -> new PasswordChanger("doctor", userID.getText()));
        viewAppointmentsButton.addActionListener(e -> new PatientList(userID.getText()));

        display.displayOn();
    }

    private void onPatientInformation(){
        new PatientInformationDoctor(userid);
        display.displayOff();
    }

    private void onLogOut(){
        new DoctorLogin();
        display.displayOff();
    }
}