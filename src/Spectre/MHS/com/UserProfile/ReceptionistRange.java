package Spectre.MHS.com.UserProfile;

import Spectre.MHS.com.LogIn.ReceptionistLogin;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Operations.PasswordChanger;
import Spectre.MHS.com.Operations.EmployeeInfo;
import Spectre.MHS.com.Operations.Receptionist.AddNewPatient;
import Spectre.MHS.com.PatientInformation.PatientInformationReceptionist;

import javax.swing.*;

public class ReceptionistRange {
    private JPanel contentPanel;
    private final String userid;
    private JButton logOutButton, changePasswordButton, patientInformationButton, addNewPatientButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final Display display = new Display("Receptionists Range", contentPanel);

    public ReceptionistRange(String userid) {
        this.userid = userid;

        String query = "SELECT * FROM receptionist WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation, contactNo, bloodGroup, address, dateOfBirth, name);

        patientInformationButton.addActionListener(e -> onPatientInformation());
        changePasswordButton.addActionListener(e -> new PasswordChanger("receptionist", userID.getText()));
        logOutButton.addActionListener(e -> onLogOut());
        addNewPatientButton.addActionListener(e -> onAddNewPatient());
        display.displayOn();
    }
    private void onPatientInformation(){
        new PatientInformationReceptionist(userid);
        display.displayOff();

    }
    private void onAddNewPatient(){
        new AddNewPatient(userid);
        display.displayOff();
    }
    private void onLogOut(){
        new ReceptionistLogin();
        display.displayOff();
    }
}
