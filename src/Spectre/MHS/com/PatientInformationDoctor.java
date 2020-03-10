package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        JFrame jFrame = new JFrame("Doctors Station");
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
        DoctorStation doctorStation = new DoctorStation(userid);
    }
}
