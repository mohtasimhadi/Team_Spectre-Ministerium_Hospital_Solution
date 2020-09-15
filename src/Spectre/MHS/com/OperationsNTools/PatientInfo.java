package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;

public class PatientInfo {
    public SQLConnector sqlConnector = new SQLConnector();
    public void getPatientInfoReceptionist(String query, JLabel name, JLabel age,
                                           JLabel gender, JLabel dateOfAdmission, JLabel dateOfAppointment,
                                           JLabel appointedDoctor, JTextField dateOfRelease, JLabel contactNo, JLabel email,
                                           JLabel bloodGroup, JTextArea prescription, JTextArea pathologyTests){
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){

                name.setText(sqlConnector.resultSet.getString("Name"));
                age.setText(sqlConnector.resultSet.getString("Age"));
                gender.setText(sqlConnector.resultSet.getString("Gender"));
                dateOfAdmission.setText(sqlConnector.resultSet.getString("DateOfAdmission"));
                dateOfAppointment.setText(sqlConnector.resultSet.getString("DateOfAppointment"));
                appointedDoctor.setText(sqlConnector.resultSet.getString("AppointedDoctor"));
                dateOfRelease.setText(sqlConnector.resultSet.getString("DateOfRelease"));
                contactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                email.setText(sqlConnector.resultSet.getString("Email"));
                bloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                prescription.setText(sqlConnector.resultSet.getString("Prescription"));
                pathologyTests.setText(sqlConnector.resultSet.getString("PathologyTests"));
            } else {
                JOptionPane.showMessageDialog(null, "No Patient With That ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void getPatientInfoDoctor(String query, JLabel jName, JLabel jAge,
                                            JLabel jGender, JLabel jDateOfAdmission, JLabel jDateOfAppointment,
                                            JTextField jDateOfRelease, JLabel jContactNo, JLabel jEmail,
                                            JLabel jBloodGroup, JTextArea jPrescription, JTextArea jPathologyTests){
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){

                jName.setText(sqlConnector.resultSet.getString("Name"));
                jAge.setText(sqlConnector.resultSet.getString("Age"));
                jGender.setText(sqlConnector.resultSet.getString("Gender"));
                jDateOfAdmission.setText(sqlConnector.resultSet.getString("DateOfAdmission"));
                jDateOfAppointment.setText(sqlConnector.resultSet.getString("DateOfAppointment"));
                jDateOfRelease.setText(sqlConnector.resultSet.getString("DateOfRelease"));
                jContactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                jEmail.setText(sqlConnector.resultSet.getString("Email"));
                jBloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                jPrescription.setText(sqlConnector.resultSet.getString("Prescription"));
                jPathologyTests.setText(sqlConnector.resultSet.getString("PathologyTests"));
            } else {
                JOptionPane.showMessageDialog(null, "No Patient With That ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void getPatientInfoPathologist(String query, JLabel jName, JLabel jAge,
                                                  JLabel jGender, JLabel jBloodGroup, JTextArea jPathologyTests){
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();



        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){

                jName.setText(sqlConnector.resultSet.getString("Name"));
                jAge.setText(sqlConnector.resultSet.getString("Age"));
                jGender.setText(sqlConnector.resultSet.getString("Gender"));
                jBloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                jPathologyTests.setText(sqlConnector.resultSet.getString("PathologyTests"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void updatePatientInfo(String query){
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}