package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;

public class PasswordChanger {
    private JPasswordField OldPasswordField;
    private JPasswordField NewPasswordField;
    private JButton OKButton;
    private JPanel PasswordChangerPanel;
    private Display display;

    public PasswordChanger(String tableName, String ID) {
        OKButton.addActionListener(e -> {

            String oldPassword = Arrays.toString(OldPasswordField.getPassword());
            String newPassword = Arrays.toString(NewPasswordField.getPassword());

            Encryption encryption = new Encryption();

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
                    closeThis();
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password does not Match.");
                }

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });

        displayThis();
    }

    private void displayThis(){
        display = new Display("Password Changer", PasswordChangerPanel);
        display.displayOn();
        display.changeSize(400, 200);
    }
    private void closeThis(){
        display.displayOff();
    }
}
