package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class PathologistLocale {
    private JPanel contentPanel;
    private JButton logOutButton, changePassword, patientInformationButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    public String userid;
    private final Display display = new Display("Pathologists Locale", contentPanel);

    public PathologistLocale(String userid) {
        this.userid = userid;
        display.displayOn();
        String query = "SELECT * FROM pathologist WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> {
            display.displayOff();
            onLogOut();
        });

        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.displayOff();
        });
    }

    void onPatientInformation(){
        new PatientInformationPathologist(userid);
    }

    void onLogOut(){
        new PathologistLogIn();
    }
}
