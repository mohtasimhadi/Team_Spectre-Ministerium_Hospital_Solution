package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
    private String userid;
    private final Display display = new Display("Add New Employee", contentPanel);
    SQLConnector sqlConnector = new SQLConnector();


    public AddNewEmployee(String userid) {
        this.userid = userid;
        display.DisplayOn();

        backButton.addActionListener(e -> {
            onBack();
            display.DisplayOff();
        });
        addEmployeeButton.addActionListener(e -> {
            try {
                onAddEmployeeButton();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        });
    }

    void onAddEmployeeButton() throws NoSuchAlgorithmException {

        String designation, sql;
        designation = this.designation.getSelectedItem().toString();
        if((designation.equals("Administrative Director"))||designation.equals("Human Resource Management Admin")){
            sql = "INSERT INTO admin (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationalQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        } else
            sql = "INSERT INTO " + designation.toLowerCase() + " (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationalQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        addEmployee(sql);

/*        if(designation.equals("Doctor")){
            String sql = "INSERT INTO doctor (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
            addEmployee(sql);
        }
        else if (designation.equals("Receptionist")){
            String sql = "INSERT INTO receptionist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
            addEmployee(sql);

        }
        else if (designation.equals("Pathologist")){
            String sql = "INSERT INTO pathologist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
            addEmployee(sql);

        }
        else {
            String sql = "INSERT INTO admin (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
            addEmployee(sql);
        }*/
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
            sqlConnector.preparedStatement.setString(6, gender.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(7, educationalQualification.getText());
            sqlConnector.preparedStatement.setString(8, designation.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(9, bloodGroup.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(10, dateOfJoin.getText());
            sqlConnector.preparedStatement.setString(11, encryption.encrypt(password.getText()));

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
    }
}
