package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.sql.SQLException;

public class Update {

    public static void onUpdatePathologist(String query, String ID, String data) {
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, data);
            sqlConnector.preparedStatement.setString(2, ID);
            sqlConnector.preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateDoctor(String query, String iD, String dateOfRelease, String pathologyTests, String prescription ) {
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, dateOfRelease);
            sqlConnector.preparedStatement.setString(2, pathologyTests);
            sqlConnector.preparedStatement.setString(3, prescription);
            sqlConnector.preparedStatement.setString(4, iD);
            sqlConnector.preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateHR(String query, String id, String name, String dateOfBirth, String address, String contactNo,
                                  String email, String gender, String education, String designation, String bloodGroup, String dataOfJoin) {
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, name);
            sqlConnector.preparedStatement.setString(2, dateOfBirth);
            sqlConnector.preparedStatement.setString(3, address);
            sqlConnector.preparedStatement.setString(4, contactNo);
            sqlConnector.preparedStatement.setString(5, email);
            sqlConnector.preparedStatement.setString(6, gender);
            sqlConnector.preparedStatement.setString(7, education);
            sqlConnector.preparedStatement.setString(8, designation);
            sqlConnector.preparedStatement.setString(9, bloodGroup);
            sqlConnector.preparedStatement.setString(10, dataOfJoin);
            sqlConnector.preparedStatement.setString(11, id);
            sqlConnector.preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateReceptionist(String query, String iD, String dateOfRelease) {
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, dateOfRelease);
            sqlConnector.preparedStatement.setString(2, iD);
            sqlConnector.preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}