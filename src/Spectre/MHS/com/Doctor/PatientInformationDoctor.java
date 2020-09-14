package Spectre.MHS.com.Doctor;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.Receptionist.PatientInformationReceptionist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInformationDoctor {
    private JButton jbackButton;
    private JButton jupdateButton;
    private JButton jreferButton;
    private JButton jrefreshButton;
    private JButton jviewButton;
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
        display.DisplayOn();

        jbackButton.addActionListener(e -> {
            onBack();
            display.DisplayOff();
        });

        jrefreshButton.addActionListener(e -> {
            onRefresh();
        });

        jviewButton.addActionListener(e -> {
            onView();

        });

        jupdateButton.addActionListener(e -> {
            onUpdate();

        });
    }

    void onBack(){
        new DoctorStation(userid);
    }

    void onRefresh(){
        display.DisplayOff();
        new PatientInformationDoctor(userid);
    }

    void onView(){
        String patientID = jPatientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoDoctor(query,jName,jAge,jGender,jDateOfAdmission,jDateOfAppointment,jDateOfRelease,jContactNo,jEmail,jBloodGroup,jPrescription,jPathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String patientID = jPatientID.getText();
        String dateOfRelease = jDateOfRelease.getText();
        String prescription=jPrescription.getText();
        String pathologyTests=jPathologyTests.getText();
        PatientInfo patientInfo = new PatientInfo();
        String query = ("UPDATE patient SET DateOfRelease ='"+dateOfRelease+ "', Prescription ='"+prescription+"', PathologyTests ='"+pathologyTests+"' WHERE ID ="+patientID);
        //if(())              //Rafi HELP
        patientInfo.updatePatientInfo(query);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }
}
