package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrativeDirector {
    private JButton logOutButton;
    private JPanel contentPanel;
    private JButton viewEmployeeButton;
    private JButton viewPatientButton;
    private JLabel jID;
    private JLabel jName;
    private JLabel jDateOfBirth;
    private JLabel jAddress;
    private JLabel jContactNo;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;
    private JButton changePasswordButton;
    private String userid;
    private Display display = new Display("Administrative Director", contentPanel);

    public AdministrativeDirector(String userid) {
        this.userid = userid;
        display.DisplayOn();

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "SELECT * FROM admin WHERE ID=?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                jID.setText(sqlConnector.resultSet.getString("ID"));
                jJoiningDate.setText(sqlConnector.resultSet.getString("DateOfJoin"));
                jGender.setText(sqlConnector.resultSet.getString("Gender"));
                jEmail.setText(sqlConnector.resultSet.getString("Email"));
                jDesignation.setText(sqlConnector.resultSet.getString("Designation"));
                jContactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                jBloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                jAddress.setText(sqlConnector.resultSet.getString("Address"));
                jDateOfBirth.setText(sqlConnector.resultSet.getString("DateOfBirth"));
                jName.setText(sqlConnector.resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.DisplayOff();
                onLogOut();
            }
        });
    }

    void onLogOut(){
        AdminLogin adminLogin = new AdminLogin();
    }
}
