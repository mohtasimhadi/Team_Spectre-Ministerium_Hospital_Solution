package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class AddNewEmployee {
    private JButton backButton;
    private JPanel contentPanel;
    private JPasswordField password;
    private JTextField dateOfJoin;
    private JButton addEmployeeButton;
    private JComboBox designation;
    private JTextField name;
    private JTextField dateOfBirth;
    private JTextField contactNo;
    private JTextField address;
    private JTextField email;
    private JComboBox gender;
    private JTextField educationalQualification;
    private JComboBox bloodGroup;
    private final String userid;
    private final Display display = new Display("Add New Employee", contentPanel);
    SQLConnector sqlConnector = new SQLConnector();


    public AddNewEmployee(String userid) {
        this.userid = userid;
        display.DisplayOn();

        backButton.addActionListener(e -> onBack());
        addEmployeeButton.addActionListener(e -> onAddEmployeeButton());
    }

    void onAddEmployeeButton() {

        String designation, sql;
        designation = Objects.requireNonNull(this.designation.getSelectedItem()).toString();
        if((designation.equals("Administrative Director"))||designation.equals("Human Resource Management Admin")){
            sql = "INSERT INTO admin (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationalQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        } else
            sql = "INSERT INTO " + designation.toLowerCase() + " (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationalQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        addEmployee(sql);
    }

    void addEmployee(String sql){
        sqlConnector.connect();
        Encryption encryption = new Encryption();
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
            sqlConnector.preparedStatement.setString(1, name.getText());
            sqlConnector.preparedStatement.setString(2, dateOfBirth.getText());
            sqlConnector.preparedStatement.setString(3, contactNo.getText());
            sqlConnector.preparedStatement.setString(4, address.getText());
            sqlConnector.preparedStatement.setString(5, email.getText());
            sqlConnector.preparedStatement.setString(6, Objects.requireNonNull(gender.getSelectedItem()).toString());
            sqlConnector.preparedStatement.setString(7, educationalQualification.getText());
            sqlConnector.preparedStatement.setString(8, Objects.requireNonNull(designation.getSelectedItem()).toString());
            sqlConnector.preparedStatement.setString(9, Objects.requireNonNull(bloodGroup.getSelectedItem()).toString());
            sqlConnector.preparedStatement.setString(10, dateOfJoin.getText());
            sqlConnector.preparedStatement.setString(11, encryption.encrypt(Arrays.toString(password.getPassword())));

            sqlConnector.preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(contentPanel, "User Inserted");

            address.setText("");
            bloodGroup.setSelectedIndex(-1);
            contactNo.setText("");
            dateOfBirth.setText("");
            dateOfJoin.setText("");
            educationalQualification.setText("");
            designation.setSelectedIndex(-1);
            name.setText("");
            email.setText("");
            gender.setSelectedIndex(-1);
            password.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void onBack(){
        new AdminHR(userid);
        display.DisplayOff();
    }
}
