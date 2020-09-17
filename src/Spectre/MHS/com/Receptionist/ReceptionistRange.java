package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.EmployeeInfo;
import javax.swing.*;

public class ReceptionistRange {
    private JPanel contentPanel;
    private final String userid;
    private JButton logOutButton, changePasswordButton, patientInformationButton, addNewPatientButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final Display display = new Display("Receptionists Range", contentPanel);

    public ReceptionistRange(String userid) {
        this.userid = userid;
        display.displayOn();

        String query = "SELECT * FROM receptionist WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation, contactNo, bloodGroup, address, dateOfBirth, name);

        patientInformationButton.addActionListener(e -> onPatientInformation());
        changePasswordButton.addActionListener(e -> new PasswordChanger("receptionist", userID.getText()));
        logOutButton.addActionListener(e -> onLogOut());
        addNewPatientButton.addActionListener(e -> onAddNewPatient());
    }
    private void onPatientInformation(){
        display.displayOff();
        new PatientInformationReceptionist(userid);

    }
    private void onAddNewPatient(){
        display.displayOff();
        new AddNewPatient(userid);
    }
    private void onLogOut(){
        display.displayOff();
        new ReceptionistLogin();
    }
}
