package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.sql.SQLException;

public class Update {

    public static void onUpdatePathologist(String query, String ID, String data) {
        SQLConnector sqlConnector = new SQLConnector();

        try {
            String[] parameters = new String[2];
            parameters[0] = data;
            parameters[1] = ID;
            sqlConnector.executeUpdate(parameters, query, 2);
            sqlConnector.preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateDoctor(String query, String ID, String dateOfRelease, String pathologyTests, String prescription ) {
        SQLConnector sqlConnector = new SQLConnector();

        try {
            String[] parameters = new String[4];
            parameters[0] = dateOfRelease;
            parameters[1] = pathologyTests;
            parameters[2] = prescription;
            parameters[3] = ID;
            sqlConnector.executeUpdate(parameters, query, 4);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateHR(String query, String ID, String name, String dateOfBirth, String address, String contactNo,
                                  String email, String gender, String education, String designation, String bloodGroup, String dataOfJoin) {
        SQLConnector sqlConnector = new SQLConnector();

        try {
            String[] parameters = new String[11];
            parameters[0] = name;
            parameters[1] = dateOfBirth;
            parameters[2] = address;
            parameters[3] = contactNo;
            parameters[4] = email;
            parameters[5] = gender;
            parameters[6] = education;
            parameters[7] = designation;
            parameters[8] = bloodGroup;
            parameters[9] = dataOfJoin;
            parameters[10] = ID;
            sqlConnector.executeUpdate(parameters, query, 11);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateReceptionist(String query, String ID, String dateOfRelease) {
        SQLConnector sqlConnector = new SQLConnector();

        try {
            String[] parameters = new String[2];
            parameters[0] = dateOfRelease;
            parameters[1] = ID;
            sqlConnector.executeUpdate(parameters, query, 2);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}