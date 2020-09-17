package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class AddNewEmployee {

    private JPanel contentPanel;
    private JPasswordField password;
    private JButton backButton, addEmployeeButton;
    private JComboBox<String> designation, gender, bloodGroup;
    private JTextField name, contactNo, address, email, educationalQualification;
    private final String userid;
    private DatePicker dateOfBirth, dateOfJoin;
    private final Display display = new Display("Add New Employee", contentPanel);
    SQLConnector sqlConnector = new SQLConnector();

    public AddNewEmployee(String userid) {
        this.userid = userid;
        display.displayOn();
        backButton.addActionListener(e -> onBack());
        addEmployeeButton.addActionListener(e -> onAddEmployeeButton());
        gender.setSelectedItem(null);
        bloodGroup.setSelectedItem(null);
        designation.setSelectedItem(null);
    }

    private void onAddEmployeeButton() {
        if(!checkIfAllAreFilled()){
            JOptionPane.showMessageDialog(null, "Please Fill Out all the Information");
            return;
        }
        String designation, sql;
        designation = Objects.requireNonNull(this.designation.getSelectedItem()).toString();
        if((designation.equals("Administrative Director"))||designation.equals("Human Resource Management Admin")){
            designation = "admin";
        }
        sql = "INSERT INTO " + designation.toLowerCase() + " (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        addEmployee(sql);
    }

    private void addEmployee(String sql){
        Encryption encryption = new Encryption();
        try {
            String[] parameters = new String[11];

            parameters[0] = name.getText();
            parameters[1] = dateOfBirth.getText();
            parameters[2] = contactNo.getText();
            parameters[3] = address.getText();
            parameters[4] = email.getText();
            parameters[5] = Objects.requireNonNull(gender.getSelectedItem()).toString();
            parameters[6] = educationalQualification.getText();
            parameters[7] = Objects.requireNonNull(designation.getSelectedItem()).toString();
            parameters[8] = Objects.requireNonNull(bloodGroup.getSelectedItem()).toString();
            parameters[9] = dateOfJoin.getText();
            parameters[10] = encryption.encrypt(Arrays.toString(password.getPassword()));

            sqlConnector.executeUpdate(parameters, sql, 11);
            String queryDesignation = designation.getSelectedItem().toString();
            if((queryDesignation.equals("Administrative Director"))||queryDesignation.equals("Human Resource Management Admin")){
                queryDesignation = "admin";}
            sql = "SELECT MAX(ID) FROM "+queryDesignation;
            sqlConnector.executeQuery(sql, true);
            JOptionPane.showMessageDialog(contentPanel, "Employee Inserted with ID " + sqlConnector.resultSet.getInt(1));
            display.displayOff();
            new AddNewEmployee(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void onBack(){
        new AdminHR(userid);
        display.displayOff();
    }
    boolean checkIfAllAreFilled(){
        return !name.getText().isEmpty() && !Objects.requireNonNull(designation.getSelectedItem()).toString().isEmpty() && !dateOfJoin.getText().isEmpty() && !dateOfBirth.getText().isEmpty() && !contactNo.getText().isEmpty() && !address.getText().isEmpty() && !email.getText().isEmpty() && !educationalQualification.getText().isEmpty() && !Arrays.toString(password.getPassword()).isEmpty();
    }
}
