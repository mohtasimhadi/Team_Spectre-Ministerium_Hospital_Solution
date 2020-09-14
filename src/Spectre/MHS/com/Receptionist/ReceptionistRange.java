package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class ReceptionistRange {
    private JPanel contentPanel;
    private JButton logOutButton;
    private final String userid;
    private JButton changePassword;
    private JButton patientInformationButton;
    private JButton addNewPatientButton;
    private JLabel juserid;
    private JLabel jName;
    private JLabel jDateOfBirth;
    private JLabel jAddress;
    private JLabel jContactNo;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;
    private final Display display = new Display("Receptionists Range", contentPanel);

    public ReceptionistRange(String userid) {
        this.userid = userid;
        display.displayOn();

        String query = "SELECT * FROM receptionist WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, juserid, jJoiningDate, jGender, jEmail, jDesignation, jContactNo, jBloodGroup, jAddress, jDateOfBirth, jName);

        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.displayOff();
        });

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
