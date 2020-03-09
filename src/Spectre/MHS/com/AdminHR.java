package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHR {
    private JButton logOutButton;
    private JPanel contentPanel;
    private JButton addNewEmployeeButton;
    private JButton changePassword;
    private JButton viewEmployeeButton;
    private JLabel jID;
    private JLabel jName;
    private JLabel jDateOfBirth;
    private JLabel jAddress;
    private JLabel jContactNo;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jSpecialization;
    private JLabel jBloodGroup;
    private JLabel jJoiningDate;

    public AdminHR() {
        JFrame jFrame = new JFrame("Doctors Station");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                onLogOut();
            }
        });
    }

    void onLogOut(){
        AdminLogin adminLogin = new AdminLogin();
    }

    /*public static void main(String[] args){
        AdminHR adminHR = new AdminHR();
    }*/
}
