package Spectre.MHS.com;

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

    public PatientInformationPathologist() {

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
        PathologistLocale pathologistLocale = new PathologistLocale(userid);
    }
}
