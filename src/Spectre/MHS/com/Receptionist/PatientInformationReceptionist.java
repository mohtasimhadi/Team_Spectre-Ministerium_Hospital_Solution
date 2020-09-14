package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;

public class PatientInformationReceptionist {
    private JButton jbackButton;
    private JButton jviewButton;
    private JButton jrefreshButton;
    private JButton jupdateButton;
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

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    PatientInformationReceptionist(String userid){
        this.userid = userid;
        display.displayOn();

        jbackButton.addActionListener(e -> {
            onBack();
            display.displayOff();
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
        display.displayOff();
        new ReceptionistRange(userid);
    }
    void onRefresh(){
        display.displayOff();
        new PatientInformationReceptionist(userid);
    }
    void onView(){
        String patientID = jPatientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
            patientInfo.getPatientInfoReceptionist(query,jName,jAge,jGender,jDateOfAdmission,jDateOfAppointment,jDateOfRelease,jContactNo,jEmail,jBloodGroup,jPrescription,jPathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String patientID = jPatientID.getText();
        String dateOfRelease = jDateOfRelease.getText();
        PatientInfo patientInfo = new PatientInfo();
        String query = ("UPDATE patient SET DateOfRelease ='"+dateOfRelease+ "' WHERE ID ="+patientID);
        //if(())              //Rafi HELP
            patientInfo.updatePatientInfo(query);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

}
