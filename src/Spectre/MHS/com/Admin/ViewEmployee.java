package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;
import java.sql.SQLException;

public class ViewEmployee {
    public JPanel contentPanel;
    private JButton backButton, viewEmployeeButton, updateInformationButton, removeEmployeeButton;
    private JTextField jUserID, jName, jDateOfBirth, jAddress, jContactNo, jeducationalQualification, jGender, jEmail, jDesignation, jBloodGroup, jJoiningDate;
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
        String query = ("UPDATE patient SET Name = ?, DateOfBirth = ?, Address = ?, ContactNo = ?, Email = ?, Gender = ?, EducationQualification = ?, Designation = ?, BloodGroup = ?, DateOfJoin = ?,  WHERE ID = ?");

        Update.onUpdateHR(query, jUserID.getText(), jName.getText(), jDateOfBirth.getText(), jAddress.getText(), jContactNo.getText(), jEmail.getText(), jGender.getText(), jeducationalQualification.getText(), jDesignation.getText(), jBloodGroup.getText(), jJoiningDate.getText());
    }

    void onViewEmployeeButton(){
        System.out.println("YES\n");
        String query = "SELECT * FROM doctor " +
                "UNION SELECT * FROM pathologist " +
                "UNION SELECT * FROM receptionist " +
                "UNION SELECT * FROM admin WHERE ID = " + jUserID.getText();
        System.out.println(query);
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
            if(!sqlConnector.resultSet.next()){
                JOptionPane.showMessageDialog(null, "Employee does not Exist");
                return;
            }
            jName.setText(sqlConnector.resultSet.getString("Name"));
            jDateOfBirth.setText(sqlConnector.resultSet.getString("DateOfBirth"));
            jAddress.setText(sqlConnector.resultSet.getString("Address"));
            jContactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
            jGender.setText(sqlConnector.resultSet.getString("Gender"));
            jEmail.setText(sqlConnector.resultSet.getString("email"));
            jDesignation.setText(sqlConnector.resultSet.getString("Designation"));
            jBloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
            jJoiningDate.setText(sqlConnector.resultSet.getString("DateOfJoin"));

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
