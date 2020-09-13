package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;

import javax.swing.*;

public class PathologistLocale {
    private JButton logOutButton;
    private JButton patientInformationButton;
    private JPanel contentPanel;
    private JButton changePassword;
    private JLabel juserid;
    private JLabel jName;
    private JLabel jDateOfBirth;
    private JLabel jAddress;
    private JLabel jContactNo;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jSpecialization;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;
    public String userid;
    private Display display = new Display("Pathologists Locale", contentPanel);

    public PathologistLocale(String userid) {
        this.userid = userid;
        display.DisplayOn();
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "SELECT * FROM pathologist WHERE ID=?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                juserid.setText(sqlConnector.resultSet.getString("ID"));
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

        logOutButton.addActionListener(e -> {
            display.DisplayOff();
            onLogOut();
        });

        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.DisplayOff();
        });
    }

    void onPatientInformation(){
        new PatientInformationPathologist(userid);
    }

    void onLogOut(){
        new PathologistLogIn();
    }
}
