package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistRange {
    private JPanel contentPanel;
    private JButton logOutButton;

    public ReceptionistRange() {
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
        ReceptionistLogin receptionistLogin = new ReceptionistLogin();
    }

    private JButton changePassword;
    private JButton patientInformationButton;
    private JButton addNewPatientButton;
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
    private JLabel jWorkingDays;
    private JLabel jWorkingHours;
    private JLabel jRoomNo;
}
