package Spectre.MHS.com.UserProfile;

import Spectre.MHS.com.PatientInformation.PatientInformationAdmin;
import Spectre.MHS.com.Operations.Admin.ViewEmployee;
import Spectre.MHS.com.LogIn.AdminLogin;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PasswordChanger;
import Spectre.MHS.com.OperationsNTools.EmployeeInfo;
import javax.swing.*;


public class AdministrativeDirector {
    private JPanel contentPanel;
    private JButton logOutButton, changePasswordButton, viewEmployeeButton, viewPatientButton;
    private JLabel userID, name, dateOfBirth, address, contactNo, gender, email, designation, bloodGroup, joiningDate;
    private final Display display = new Display("Administrative Director", contentPanel);

    public AdministrativeDirector(String userid) {
        display.displayOn();

        String query = "SELECT * FROM admin WHERE ID=?";
        EmployeeInfo employeeInfo = new EmployeeInfo();

        employeeInfo.getPersonalInfo(userid, query, userID, joiningDate, gender, email, designation,
                contactNo, bloodGroup, address, dateOfBirth, name);

        logOutButton.addActionListener(e -> onLogOut());
        changePasswordButton.addActionListener(e -> new PasswordChanger("admin", userID.getText()));
        viewEmployeeButton.addActionListener(e -> onViewEmployees());
        viewPatientButton.addActionListener(e -> onViewPatients());
    }

    private void onViewEmployees(){
        new ViewEmployee(userID.getText(), "Administrative Admin");
        display.displayOff();
    }

    private void onViewPatients(){
        new PatientInformationAdmin(userID.getText());
        display.displayOff();
    }

    private void onLogOut(){
        new AdminLogin();
        display.displayOff();
    }
}
