package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;

import javax.swing.*;

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
    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    PatientInformationReceptionist(String userid){
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> {
            onBack();
            display.displayOff();
        });
    }

    void onBack(){
        new ReceptionistRange(userid);
    }
}
