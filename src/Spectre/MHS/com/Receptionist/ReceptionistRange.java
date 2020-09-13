package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;

public class ReceptionistRange {
    private JPanel contentPanel;
    private JButton logOutButton;
    private final String userid;
    private JButton changePassword;
    private JButton patientInformationButton;
    private JButton addNewPatientButton;
    private JLabel juserid;
    private JLabel jName;
    private JLabel jDateOfBirth;
    private JLabel jAddress;
    private JLabel jContactNo;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;
    private final Display display = new Display("Receptionists Range", contentPanel);

    public ReceptionistRange(String userid) {
        this.userid = userid;
        display.DisplayOn();

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "SELECT * FROM receptionist WHERE ID=?";
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

        patientInformationButton.addActionListener(e -> {
            onPatientInformation();
            display.DisplayOff();
        });

        logOutButton.addActionListener(e -> {
            display.DisplayOff();
            onLogOut();
        });
        addNewPatientButton.addActionListener(e -> {
            display.DisplayOff();
            onAddNewPatient();
        });
    }
    void onPatientInformation(){
        new PatientInformationReceptionist(userid);
    }
    void onAddNewPatient(){
        new AddNewPatient(userid);
    }
    void onLogOut(){
        new ReceptionistLogin();
    }
}
