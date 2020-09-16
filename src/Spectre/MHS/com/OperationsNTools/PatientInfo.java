package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;

public class PatientInfo {

    public void getPatientInfoReceptionist(String query, JLabel name, JLabel age,
                                           JLabel gender, JLabel dateOfAdmission, JLabel dateOfAppointment,
                                           JLabel appointedDoctor, JTextField dateOfRelease, JLabel contactNo, JLabel email,
                                           JLabel bloodGroup, JTextArea prescription, JTextArea pathologyTests){
        setTexts(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
    }
    public void getPatientInfoDoctor(String query, JLabel name, JLabel age,
                                     JLabel gender, JLabel dateOfAdmission, JLabel dateOfAppointment,
                                     JTextField dateOfRelease, JLabel contactNo, JLabel email,
                                     JLabel bloodGroup, JTextArea prescription, JTextArea pathologyTests){

        setTexts(query, name, age, gender, dateOfAdmission, dateOfAppointment, null, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
    }

    public void getPatientInfoPathologist(String query, JLabel name, JLabel age, JLabel gender,
                                                 JLabel bloodGroup, JTextArea pathologyTests){
        setTexts(query, name, age, gender, null, null, null, null, null, null, bloodGroup, null, pathologyTests);
    }

    private static void setTexts(String query, JLabel name, JLabel age,
                                 JLabel gender, JLabel dateOfAdmission, JLabel dateOfAppointment,
                                 JLabel appointedDoctor, JTextField dateOfRelease, JLabel contactNo, JLabel email,
                                 JLabel bloodGroup, JTextArea prescription, JTextArea pathologyTests){
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();
        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                if(name!=null){
                    name.setText(sqlConnector.resultSet.getString("Name"));
                }
                if(age!=null){
                    age.setText(sqlConnector.resultSet.getString("Age"));
                }
                if(gender!=null){
                    gender.setText(sqlConnector.resultSet.getString("Gender"));
                }
                if(dateOfAdmission!=null){
                    dateOfAdmission.setText(sqlConnector.resultSet.getString("DateOfAdmission"));
                }
                if(dateOfAdmission!=null){
                    dateOfAppointment.setText(sqlConnector.resultSet.getString("DateOfAppointment"));
                }
                if(appointedDoctor!=null){
                    appointedDoctor.setText(sqlConnector.resultSet.getString("AppointedDoctor"));
                }
                if(dateOfRelease!=null){
                    dateOfRelease.setText(sqlConnector.resultSet.getString("DateOfRelease"));
                }
                if(contactNo!=null){
                    contactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                }
                if(email!=null){
                    email.setText(sqlConnector.resultSet.getString("Email"));
                }
                if(bloodGroup!=null){
                    bloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                }
                if(prescription!=null){
                    prescription.setText(sqlConnector.resultSet.getString("Prescription"));
                }
                if(pathologyTests!=null){
                    pathologyTests.setText(sqlConnector.resultSet.getString("PathologyTests"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Patient With That ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}