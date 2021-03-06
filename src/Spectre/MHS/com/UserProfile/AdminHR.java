package Spectre.MHS.com.UserProfile;

import Spectre.MHS.com.Operations.Admin.AddNewEmployee;
import Spectre.MHS.com.Operations.Admin.ViewEmployee;
import Spectre.MHS.com.LogIn.AdminLogin;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Operations.PasswordChanger;
import Spectre.MHS.com.Operations.EmployeeInfo;
import javax.swing.*;

public class AdminHR {
    private JPanel contentPanel;
    private JButton logOutButton, addNewEmployeeButton, changePasswordButton, viewEmployeeButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final String userid;
    private final Display display = new Display("Human Resource Management Admin", contentPanel);

    public AdminHR(String userid) {
        this.userid = userid;
        String query = "SELECT * FROM admin WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);
        logOutButton.addActionListener(e -> onLogOut());
        addNewEmployeeButton.addActionListener(e -> onAddNewEmployee());
        viewEmployeeButton.addActionListener(e -> onViewEmployee());
        changePasswordButton.addActionListener(e -> new PasswordChanger("admin", userID.getText()));

        display.displayOn();
    }

    private void onViewEmployee(){
        new ViewEmployee(userid, "Human Resource Management Admin");
        display.displayOff();
    }

    private void onAddNewEmployee(){
        new AddNewEmployee(userid);
        display.displayOff();
    }

    private void onLogOut(){
        new AdminLogin();
        display.displayOff();
    }
}
