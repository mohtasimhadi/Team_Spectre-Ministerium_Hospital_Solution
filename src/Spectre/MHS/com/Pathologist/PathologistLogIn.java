package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;

import javax.swing.*;
import java.awt.event.*;

public class PathologistLogIn{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField juserid;
    private JPasswordField jpassword;
    private LogIn logIn = new LogIn();
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
                onLogIn();
                display.DisplayOff();
            }
        });
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from pathologist where ID = ? and Password = ?";

        if(logIn.onLogIn(query, juserid.getText(), encryption.encrypt(jpassword.getText()))){
            new PathologistLocale(juserid.getText());
        } else {
            new PathologistLogIn();
        }
    }

/*    void onLogIn() throws NoSuchAlgorithmException {
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
    }*/
        public static void main(String[] args){
        new PathologistLogIn();
    }
}
