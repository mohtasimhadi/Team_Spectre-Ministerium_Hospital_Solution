package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

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
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation, contactNo, bloodGroup, address, dateOfBirth, name);

        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.displayOff();
        });

        changePasswordButton.addActionListener(e -> new PasswordChanger("receptionist", userID.getText()));

        logOutButton.addActionListener(e -> {
            display.displayOff();
            onLogOut();
        });
        addNewPatientButton.addActionListener(e -> {
            display.displayOff();
            onAddNewPatient();
        });
    }
    void onPatientInformation(){
        new PatientInformationReceptionist(userid);

    }
    void onAddNewPatient(){

        new AddNewPatient(userid);
    }
    void onLogOut(){

        new ReceptionistLogin();
    }
}
