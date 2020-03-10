package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewPatient {
    private JPanel contentPanel;
    private JButton backButton;
    private JButton addPatientButton;
    private JComboBox jGender;
    private JComboBox jBloodGroup;
    private JTextField jPatientID;
    private JTextField jName;
    private JTextField jAge;
    private JTextField jDateOfAdmission;
    private JTextField jDateOfAppointment;
    private JTextField jDateOfRelease;
    private JTextField jContactNo;
    private JTextField jEmail;
    private JTextField jAppointedDoctor;
    private JButton jViewDoctors;
    private String userid;

    public AddNewPatient(String userid) {
        this.userid = userid;
        JFrame jFrame = new JFrame("Add New Patient");
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
