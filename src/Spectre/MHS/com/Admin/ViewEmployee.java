package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import javax.swing.*;
import java.sql.SQLException;

public class ViewEmployee {
    public JPanel contentPanel;
    private JButton backButton, viewEmployeeButton, updateInformationButton, removeEmployeeButton;
    private JTextField userID, name, dateOfBirth, address,  contactNo,  Gender,  email,  designation,  bloodGroup, joiningDate;
    private String userid;
    private final Display display = new Display("View Employee", contentPanel);
    SQLConnector sqlConnector;

    public ViewEmployee(String userid, String usertype){
        this.userid = userid;
        display.displayOn();

        sqlConnector = new SQLConnector();
        sqlConnector.connect();

        backButton.addActionListener(e -> onBackButton(usertype));
        removeEmployeeButton.addActionListener(e -> onRemoveEmployeeButton());
        updateInformationButton.addActionListener(e -> onUpdateInformationButton());
        viewEmployeeButton.addActionListener(e -> onViewEmployeeButton());
    }

    void onRemoveEmployeeButton(){

    }

    void onUpdateInformationButton(){

    }

    void onViewEmployeeButton(){
        System.out.println("YES\n");
        String query = "SELECT * FROM doctor " +
                "UNION SELECT * FROM pathologist " +
                "UNION SELECT * FROM receptionist " +
                "UNION SELECT * FROM admin WHERE ID = " + userID.getText();
        System.out.println(query);
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
            if(!sqlConnector.resultSet.next()){
                JOptionPane.showMessageDialog(null, "Employee does not Exist");
                return;
            }
            name.setText(sqlConnector.resultSet.getString("Name"));
            dateOfBirth.setText(sqlConnector.resultSet.getString("DateOfBirth"));
            address.setText(sqlConnector.resultSet.getString("Address"));
            contactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
            Gender.setText(sqlConnector.resultSet.getString("Gender"));
            email.setText(sqlConnector.resultSet.getString("email"));
            designation.setText(sqlConnector.resultSet.getString("Designation"));
            bloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
            joiningDate.setText(sqlConnector.resultSet.getString("DateOfJoin"));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void onBackButton(String usertype){
        if(usertype.equals("Human Resource Management Admin")){
            new AdminHR(userid);
        } else {
            new AdministrativeDirector(userid);
        }
        display.displayOff();
    }
}
