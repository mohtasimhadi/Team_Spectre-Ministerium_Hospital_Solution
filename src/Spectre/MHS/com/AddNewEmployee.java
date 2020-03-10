package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField jBloodGroup;


    public AddNewEmployee() {
        JFrame jFrame = new JFrame("Doctors Station");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddEmployeeButton();
            }
        });
    }

    void onAddEmployeeButton(){
        SQLConnector sqlConnector = new SQLConnector();

        String Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password;

        Name = jName.getText();
        DateOfBirth = jDateOfBirth.getText();
        ContactNo = jContactNo.getText();
        Address = jAddress.getText();
        Email = jEmail.getText();
        Gender = jGender.getSelectedItem().toString();
        EducationQualification = jEducationQualification.getText();
        Designation = jDesignation.getSelectedItem().toString();
        BloodGroup = jBloodGroup.getText();
        DateOfJoin = jDateOfJoin.getText();
        Password = jPassword.getText();

        sqlConnector.connect();

        if(Designation == "Doctor"){
            try {
                String sql = "INSERT INTO doctor (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.preparedStatement.setString(1, Name);
                sqlConnector.preparedStatement.setString(2, DateOfBirth);
                sqlConnector.preparedStatement.setString(3, ContactNo);
                sqlConnector.preparedStatement.setString(4, Address);
                sqlConnector.preparedStatement.setString(5, Email);
                sqlConnector.preparedStatement.setString(6,Gender);
                sqlConnector.preparedStatement.setString(7,EducationQualification);
                sqlConnector.preparedStatement.setString(8,Designation);
                sqlConnector.preparedStatement.setString(9,BloodGroup);
                sqlConnector.preparedStatement.setString(10,DateOfJoin);
                sqlConnector.preparedStatement.setString(11,Password);

                sqlConnector.preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(contentPanel, "User Inserted");

                jAddress.setText("");
                jBloodGroup.setText("");
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
        else if (Designation == "Receptionist"){
            try {
                String sql = "INSERT INTO receptionist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.preparedStatement.setString(1, Name);
                sqlConnector.preparedStatement.setString(2, DateOfBirth);
                sqlConnector.preparedStatement.setString(3, ContactNo);
                sqlConnector.preparedStatement.setString(4, Address);
                sqlConnector.preparedStatement.setString(5, Email);
                sqlConnector.preparedStatement.setString(6,Gender);
                sqlConnector.preparedStatement.setString(7,EducationQualification);
                sqlConnector.preparedStatement.setString(8,Designation);
                sqlConnector.preparedStatement.setString(9,BloodGroup);
                sqlConnector.preparedStatement.setString(10,DateOfJoin);
                sqlConnector.preparedStatement.setString(11,Password);

                sqlConnector.preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(contentPanel, "User Inserted");

                jAddress.setText("");
                jBloodGroup.setText("");
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
        else if (Designation == "Pathologist"){
            try {
                String sql = "INSERT INTO pathologist (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.preparedStatement.setString(1, Name);
                sqlConnector.preparedStatement.setString(2, DateOfBirth);
                sqlConnector.preparedStatement.setString(3, ContactNo);
                sqlConnector.preparedStatement.setString(4, Address);
                sqlConnector.preparedStatement.setString(5, Email);
                sqlConnector.preparedStatement.setString(6,Gender);
                sqlConnector.preparedStatement.setString(7,EducationQualification);
                sqlConnector.preparedStatement.setString(8,Designation);
                sqlConnector.preparedStatement.setString(9,BloodGroup);
                sqlConnector.preparedStatement.setString(10,DateOfJoin);
                sqlConnector.preparedStatement.setString(11,Password);

                sqlConnector.preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(contentPanel, "User Inserted");

                jAddress.setText("");
                jBloodGroup.setText("");
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
        else {
            try {
                String sql = "INSERT INTO admin (Name, DateOfBirth, ContactNo, Address, Email, Gender, EducationQualification, Designation, BloodGroup, DateOfJoin, Password) values(?,?,?,?,?,?,?,?,?,?,?)";
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(sql);
                sqlConnector.preparedStatement.setString(1, Name);
                sqlConnector.preparedStatement.setString(2, DateOfBirth);
                sqlConnector.preparedStatement.setString(3, ContactNo);
                sqlConnector.preparedStatement.setString(4, Address);
                sqlConnector.preparedStatement.setString(5, Email);
                sqlConnector.preparedStatement.setString(6,Gender);
                sqlConnector.preparedStatement.setString(7,EducationQualification);
                sqlConnector.preparedStatement.setString(8,Designation);
                sqlConnector.preparedStatement.setString(9,BloodGroup);
                sqlConnector.preparedStatement.setString(10,DateOfJoin);
                sqlConnector.preparedStatement.setString(11,Password);

                sqlConnector.preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(contentPanel, "User Inserted");

                jAddress.setText("");
                jBloodGroup.setText("");
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
    }
}
