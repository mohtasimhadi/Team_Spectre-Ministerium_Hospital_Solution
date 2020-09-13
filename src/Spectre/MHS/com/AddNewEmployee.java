package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class AddNewEmployee {
    private JButton backButton;
    private JPanel contentPanel;
    private JPasswordField jPassword;
    private JTextField jDateOfJoin;
    private JButton addEmployeeButton;
    private JComboBox jDesignation;
    private JTextField jName;
    private JTextField jDateOfBirth;
    private JTextField jContactNo;
    private JTextField jAddress;
    private JTextField jEmail;
    private JComboBox jGender;
    private JTextField jEducationQualification;
    private JComboBox jBloodGroup;
    private String userid;
    private Display display = new Display("Add New Employee", contentPanel);
    SQLConnector sqlConnector = new SQLConnector();


    public AddNewEmployee(String userid) {
        this.userid = userid;
        display.DisplayOn();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
                display.DisplayOff();
            }
        });
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onAddEmployeeButton();
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    void onAddEmployeeButton() throws NoSuchAlgorithmException {
        String Designation;
        Designation = jDesignation.getSelectedItem().toString();

        // Fixed Type Based Conditioning
        String sql = "INSERT INTO " + Designation.toLowerCase() + " (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
        addEmployee(sql);

//        if(Designation == "Doctor"){
//            String sql = "INSERT INTO doctor (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
//            addEmployee(sql);
//        }
//        else if (Designation == "Receptionist"){
//            String sql = "INSERT INTO receptionist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
//            addEmployee(sql);
//
//        }
//        else if (Designation == "Pathologist"){
//            String sql = "INSERT INTO pathologist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
//            addEmployee(sql);
//
//        }
//        else {
//            String sql = "INSERT INTO admin (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
//            addEmployee(sql);
//        }
    }

    void addEmployee(String sql){
        sqlConnector.connect();
        Encryption encryption = new Encryption();
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
            sqlConnector.preparedStatement.setString(1, jName.getText());
            sqlConnector.preparedStatement.setString(2, jDateOfBirth.getText());
            sqlConnector.preparedStatement.setString(3, jContactNo.getText());
            sqlConnector.preparedStatement.setString(4, jAddress.getText());
            sqlConnector.preparedStatement.setString(5, jEmail.getText());
            sqlConnector.preparedStatement.setString(6,jGender.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(7,jEducationQualification.getText());
            sqlConnector.preparedStatement.setString(8,jDesignation.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(9,jBloodGroup.getSelectedItem().toString());
            sqlConnector.preparedStatement.setString(10,jDateOfJoin.getText());
            sqlConnector.preparedStatement.setString(11, encryption.Encrypt(jPassword.getText()));

            sqlConnector.preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(contentPanel, "User Inserted");

            jAddress.setText("");
            jBloodGroup.setSelectedIndex(-1);
            jContactNo.setText("");
            jDateOfBirth.setText("");
            jDateOfJoin.setText("");
            jEducationQualification.setText("");
            jDesignation.setSelectedIndex(-1);
            jName.setText("");
            jEmail.setText("");
            jGender.setSelectedIndex(-1);
            jPassword.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void onBack(){
        AdminHR adminHR = new AdminHR(userid);
    }
}
