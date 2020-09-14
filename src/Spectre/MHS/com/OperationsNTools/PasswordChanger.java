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

    public PasswordChanger(String table_name, int ID) {
        OKButton.addActionListener(e -> {

            String oldPassword = Arrays.toString(OldPasswordField.getPassword());
            String newPassword = Arrays.toString(NewPasswordField.getPassword());

            Encryption encryption = new Encryption();

            String oldPasswordQuery = "SELECT Password FROM " + table_name + " WHERE ID = " + ID;
            String newPasswordQuery = "UPDATE " + table_name + " SET Password = " + encryption.encrypt(newPassword) + " WHERE ID = " + ID;

            SQLConnector sqlConnector = new SQLConnector();
            sqlConnector.connect();
            try {
                sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(oldPasswordQuery);
                sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                sqlConnector.resultSet.next();
                if(sqlConnector.resultSet.getString(1).equals(encryption.encrypt(oldPassword))) {
                    sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(newPasswordQuery);
                    sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                    JOptionPane.showMessageDialog(null, "Password has been successfully changed");
                    closeThis();
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password does not Match.");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public void displayThis(){
        display = new Display("Password Changer", PasswordChangerPanel);
        display.displayOn();
        display.changeSize(400, 200);
    }
    public void closeThis(){
        display.displayOff();
    }

    public static void main(String[] args) {
       PasswordChanger p = new PasswordChanger("doctor", 2001);
       p.displayThis();
    }

}
