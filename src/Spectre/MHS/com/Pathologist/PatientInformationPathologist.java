package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.Tools.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInformationPathologist {
    private JButton backButton;
    private JButton updateButton;
    private JButton refreshButton;
    private JPanel contentPanel;
    private JTextArea jPathologyTests;
    private JTextField jPatientID;
    private JButton viewButton;
    private JLabel jName;
    private JLabel jAge;
    private JLabel jGender;
    private JLabel jBloodGroup;
    private String userid;
    private Display display = new Display("Patient Information", contentPanel);

    public PatientInformationPathologist(String userid) {
        this.userid = userid;
        display.DisplayOn();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
                display.DisplayOff();
            }
        });
    }
    void onBack(){
        PathologistLocale pathologistLocale = new PathologistLocale(userid);
    }
}
