package Spectre.MHS.com.UserProfile;

import Spectre.MHS.com.LogIn.PathologistLogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.EmployeeInfo;
import Spectre.MHS.com.PatientInformation.PatientInformationPathologist;

import javax.swing.*;

public class PathologistLocale {
    private JPanel contentPanel;
    private JButton logOutButton, changePassword, patientInformationButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;

    public String userid;
    private final Display display = new Display("Pathologists Locale", contentPanel);

    public PathologistLocale(String userid) {
        this.userid = userid;
        String query = "SELECT * FROM pathologist WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> onLogOut());
        patientInformationButton.addActionListener(e -> onPatientInformation());
        changePassword.addActionListener(e -> new PasswordChanger("pathologist", userID.getText()));
        display.displayOn();
    }

    private void onPatientInformation(){
        new PatientInformationPathologist(userid);
        display.displayOff();
    }

    private void onLogOut(){
        new PathologistLogIn();
        display.displayOff();
    }
}