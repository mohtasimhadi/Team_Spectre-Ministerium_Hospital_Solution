package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInformationReceptionist {
    private JButton backButton;
    private JPanel contentPanel;
    private JTextField jPatientID;
    private JLabel jName;
    private JLabel jAge;
    private JLabel jGender;
    private JLabel jDateOfAdmission;
    private JLabel jDateOfAppointment;
    private JTextField jDateOfRelease;
    private JLabel jContactNo;
    private JLabel jEmail;
    private JLabel jBloodGroup;
    private JTextArea jPrescription;
    private JTextArea jPathologyTests;
    private JButton viewButton;
    private JButton refreshButton;
    private JButton updateButton;
    private String userid;
    private Display display = new Display("Patient Information");

    PatientInformationReceptionist(String userid){
        this.userid = userid;
        display.DisplayOn(contentPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
                display.DisplayOff();
            }
        });
    }

    void onBack(){
        ReceptionistRange receptionistRange = new ReceptionistRange(userid);
    }
}
