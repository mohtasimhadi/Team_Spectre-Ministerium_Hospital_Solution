package Spectre.MHS.com.Doctor;
import Spectre.MHS.com.OperationsNTools.Display;

import javax.swing.*;

public class PatientInformationDoctor {
    private JButton backButton;
    private JButton updateButton;
    private JButton referButton;
    private JButton refreshButton;
    private JButton viewButton;
    private JTextField jPatientID;
    private JTextArea jPrescription;
    private JLabel jName;
    private JLabel jAge;
    private JLabel jGender;
    private JLabel jDateOfAdmission;
    private JLabel jDateOfAppointment;
    private JTextArea jPathologyTests;
    private JTextField jDateOfRelease;
    private JPanel contentPanel;
    private JLabel jBloodGroup;
    private JLabel jEmail;
    private JLabel jContactNo;
    private String userid;
    private Display display = new Display("Patient Information", contentPanel);

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> {
            onBack();
            display.displayOff();
        });
    }
    void onBack(){
        new DoctorStation(userid);
    }
}
