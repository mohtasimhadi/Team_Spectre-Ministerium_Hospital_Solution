package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Encryption;
import Spectre.MHS.com.Tools.SQLConnector;

import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class PathologistLogIn{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField juserid;
    private JPasswordField jpassword;
    private Display display = new Display("Pathologist Log In", contentPanel);

    public PathologistLogIn() {
        display.DisplayOn();

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onLogIn();
                    display.DisplayOff();
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn() throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        String userid = juserid.getText();
        String password = encryption.Encrypt(jpassword.getText());

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "select * from pathologist where ID = ? and Password = ?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2, password);

            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if (sqlConnector.resultSet.next()) {
                PathologistLocale pathologistLocale = new PathologistLocale(userid);
            } else {
                JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
                PathologistLogIn pathologistLogIn = new PathologistLogIn();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args){
        PathologistLogIn pathologistLogIn = new PathologistLogIn();
    }
}
