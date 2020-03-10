package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistRange {
    private JPanel contentPanel;
    private JButton logOutButton;
    private String userid;
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
    private JLabel jSpecialization;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;

    public ReceptionistRange(String userid) {
        this.userid = userid;
        JFrame jFrame = new JFrame("Receptionist Range");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

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

        patientInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPatientInformation();
                jFrame.setVisible(false);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                onLogOut();
            }
        });
        addNewPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                onAddNewPatient();
            }
        });
    }
    void onPatientInformation(){
        PatientInformationReceptionist patientInformationReceptionist = new PatientInformationReceptionist(userid);
    }
    void onAddNewPatient(){
        AddNewPatient addNewPatient = new AddNewPatient(userid);
    }
    void onLogOut(){
        ReceptionistLogin receptionistLogin = new ReceptionistLogin();
    }
}
