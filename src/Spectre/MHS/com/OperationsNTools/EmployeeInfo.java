package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;

public class EmployeeInfo {
    public void getPersonalInfo(String userid, String query,
                                JLabel ID, JLabel joiningDate, JLabel gender,
                                JLabel email, JLabel designation,
                                JLabel contactNo, JLabel bloodGroup, JLabel address,
                                JLabel dateOfBirth, JLabel name) {
        SQLConnector sqlConnector = new SQLConnector();
        //sqlConnector.connect();

        try {

            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if (sqlConnector.resultSet.next()) {
                ID.setText(sqlConnector.resultSet.getString("ID"));
                joiningDate.setText(sqlConnector.resultSet.getString("DateOfJoin"));
                gender.setText(sqlConnector.resultSet.getString("Gender"));
                email.setText(sqlConnector.resultSet.getString("Email"));
                designation.setText(sqlConnector.resultSet.getString("Designation"));
                contactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                bloodGroup.setText(sqlConnector.resultSet.getString("BloodGroup"));
                address.setText(sqlConnector.resultSet.getString("Address"));
                dateOfBirth.setText(sqlConnector.resultSet.getString("DateOfBirth"));
                name.setText(sqlConnector.resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getDoctorList(String query) {
        SQLConnector sqlConnector = new SQLConnector();
        //sqlConnector.connect();

        try {
            sqlConnector.executeQuery(query, false);/*
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
