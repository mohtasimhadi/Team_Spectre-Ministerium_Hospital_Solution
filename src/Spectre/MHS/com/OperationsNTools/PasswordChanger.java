package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PasswordChanger {
    private JPasswordField OldPasswordField;
    private JPasswordField NewPasswordField;
    private JButton OKButton;
    private JPanel PasswordChangerPanel;
    private Display display;

    public PasswordChanger(String table_name, int ID) {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String oldPassword = OldPasswordField.getText();
                String newPassword = NewPasswordField.getText();

                Encryption encryption = new Encryption();

                String oldPasswordQuery = "SELECT Password FROM " + table_name + " WHERE ID = " + ID;
                String newPasswordQuery = "UPDATE " + table_name + " SET Password = " + encryption.encrypt(newPassword) + " WHERE ID = " + ID;

                SQLConnector sqlConnector = new SQLConnector();
                sqlConnector.connect();
                try {
                    sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(oldPasswordQuery);
                    sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                    sqlConnector.resultSet.next();
                    if(sqlConnector.resultSet.getString(1) == encryption.encrypt(oldPassword)) {
                        sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(newPasswordQuery);
                        sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
                        JOptionPane.showMessageDialog(null, "Password has been successfully changed");
                        close_this();
                    } else {
                        JOptionPane.showMessageDialog(null, "Old Password does not Match.");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void Display_This(){
        display = new Display("Password Changer", PasswordChangerPanel);
        display.displayOn();
        display.changeSize(400, 200);
    }
    public void close_this(){
        display.displayOff();
    }

    public static void main(String[] args) {
       PasswordChanger p = new PasswordChanger("doctor", 2001);
       p.Display_This();
    }

}
