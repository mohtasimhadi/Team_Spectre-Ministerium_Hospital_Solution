package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;

public class PasswordChanger {
    private Display display;
    private JPanel PasswordChangerPanel;
    private JButton OKButton, cancelButton;
    private JPasswordField OldPasswordField, NewPasswordField;

    public PasswordChanger(String tableName, String ID) {
        OKButton.addActionListener(e -> {

            display = new Display("Change Password", PasswordChangerPanel);
            Encryption encryption = new Encryption();
            String oldPassword = Arrays.toString(OldPasswordField.getPassword());
            String newPassword = Arrays.toString(NewPasswordField.getPassword());
            String oldPasswordQuery = "SELECT Password FROM " + tableName + " WHERE ID = " + ID;
            String newPasswordQuery = "UPDATE " + tableName + " SET Password = '" + encryption.encrypt(newPassword) + "' WHERE ID = " + ID;

            SQLConnector sqlConnector = new SQLConnector();
            sqlConnector.connect();
            try {
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(oldPasswordQuery);
                sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                sqlConnector.resultSet.next();
                if(sqlConnector.resultSet.getString(1).equals(encryption.encrypt(oldPassword))) {
                    sqlConnector.statement = sqlConnector.connection.createStatement();
                    sqlConnector.statement.executeUpdate(newPasswordQuery);
                    JOptionPane.showMessageDialog(null, "Password has been successfully changed");
                    display.displayOff();
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password does not Match.");
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });
        display.displayOn();
        display.changeSize(200, 400);
        cancelButton.addActionListener(e -> display.displayOff());
    }
}
