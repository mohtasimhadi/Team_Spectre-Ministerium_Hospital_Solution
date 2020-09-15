package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrativeDirector {
    private JPanel contentPanel;
    private JButton logOutButton, changePasswordButton, viewEmployeeButton, viewPatientButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final Display display = new Display("Administrative Director", contentPanel);

    public AdministrativeDirector(String userid) {
        display.displayOn();
        String query = "SELECT * FROM admin WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);
        logOutButton.addActionListener(e -> {
            display.displayOff();
            onLogOut();
        });
        changePasswordButton.addActionListener(e -> {
            new PasswordChanger("admin", userID.getText());
        });
        viewEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onViewEmployees();
            }
        });
        viewPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onViewPatients();
            }
        });
    }

    void onViewEmployees(){
        new ViewEmployee(userID.getText(), "Administrative Admin");
        display.displayOff();
    }

    void onViewPatients(){
        new PatientInformationAdmin(userID.getText());
        display.displayOff();
    }

    void onLogOut(){
        new AdminLogin();
    }
}
