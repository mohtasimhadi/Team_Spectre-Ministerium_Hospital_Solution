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

    PatientInformationReceptionist(String userid){
        this.userid = userid;

        JFrame jFrame = new JFrame("Patient Information");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
                jFrame.setVisible(false);
            }
        });
    }

    void onBack(){
        ReceptionistRange receptionistRange = new ReceptionistRange(userid);
    }
}
