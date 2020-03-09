package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathologistLocale {
    private JButton logOutButton;
    private JButton patientInformationButton;
    private JPanel contentPanel;

    private JButton changePassword;
    private JLabel jID;
    private JLabel jName;
    private JLabel jDOB;
    private JLabel jAddress;
    private JLabel jContact;
    private JLabel jGender;
    private JLabel jEmail;
    private JLabel jDesignation;
    private JLabel jSpecialization;
    private JLabel jBlood;
    private JLabel jJoiningDate;
    private JLabel jWorkingDays;
    private JLabel jWorkHours;
    private JLabel jRoomNo;


    public PathologistLocale() {

        JFrame jFrame = new JFrame("Pathologist Locale");
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
        PathologistLogIn logIn = new PathologistLogIn();
    }

    /*public static void main(String[] args){
        PathologistLocale pathologistLocale = new PathologistLocale();
    }*/


}
