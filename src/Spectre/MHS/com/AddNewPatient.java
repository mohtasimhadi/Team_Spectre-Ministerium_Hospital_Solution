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
    private Display display = new Display("Add New Patient", contentPanel);

    public AddNewPatient(String userid) {
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
        ReceptionistRange receptionistRange = new ReceptionistRange(userid);
    }
}
