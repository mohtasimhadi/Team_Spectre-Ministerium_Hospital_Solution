package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class AdminHR {
    private JPanel contentPanel;
    private JButton logOutButton, addNewEmployeeButton, changePasswordButton, viewEmployeeButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final String userid;
    private final Display display = new Display("Human Resource Management Admin", contentPanel);

    public AdminHR(String userid) {
        this.userid = userid;
        display.displayOn();
        String query = "SELECT * FROM admin WHERE ID=?";
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);
        logOutButton.addActionListener(e -> onLogOut());
        addNewEmployeeButton.addActionListener(e -> onAddNewEmployee());
        viewEmployeeButton.addActionListener(e -> onViewEmployee());
    }

    void onViewEmployee(){
        new ViewEmployee(userid, "Human Resource Management Admin");
        display.displayOff();
    }

    void onAddNewEmployee(){
        new AddNewEmployee(userid);
        display.displayOff();
    }

    void onLogOut(){
        new AdminLogin();
        display.displayOff();
    }
}
