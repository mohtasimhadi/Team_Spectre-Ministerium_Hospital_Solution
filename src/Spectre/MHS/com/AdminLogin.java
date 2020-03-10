package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class AdminLogin{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField juserid;
    private JPasswordField jpassword;
    private JComboBox jusertype;



    public AdminLogin() {
        JFrame jFrame = new JFrame("Admin Log In");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onLogIn();
                    jFrame.setVisible(false);
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void onLogIn() throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        String username = juserid.getText();
        String password = encryption.Encrypt(jpassword.getText());
        String usertype = jusertype.getSelectedItem().toString();

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "select * from admin where ID = ? and Password = ? and Designation = ?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, username);
            sqlConnector.preparedStatement.setString(2,password);
            sqlConnector.preparedStatement.setString(3, usertype);

            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                if(usertype=="HR Admin"){
                    AdminHR adminHR = new AdminHR();
                }
                if(usertype=="Administrative Director"){
                    AdminstrativeDirector adminstrativeDirector = new AdminstrativeDirector();
                }
            }
            else {
                JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
                AdminLogin adminLogin = new AdminLogin();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void onExit(){
        System.exit(0);
    }

    public static void main(String[] args){
        AdminLogin adminLogin = new AdminLogin();
    }
}
