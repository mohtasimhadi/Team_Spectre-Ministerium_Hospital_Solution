package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;

import javax.swing.*;

public class PatientInformationAdmin {
    private JButton jbackButton;
    private JButton jviewButton;
    private JButton jrefreshButton;
    private JPanel contentPanel;
    private JTextField jPatientID;
    private JLabel jName;
    private JLabel jAge;
    private JLabel jGender;
    private JLabel jDateOfAdmission;
    private JLabel jDateOfAppointment;
    private JLabel jAppointedDoctor;
    private JTextField jDateOfRelease;
    private JLabel jContactNo;
    private JLabel jEmail;
    private JLabel jBloodGroup;
    private JTextArea jPrescription;
    private JTextArea jPathologyTests;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

     public PatientInformationAdmin(String userid){
        this.userid = userid;
        display.displayOff();

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

    }

    void onBack(){
        display.displayOff();
        new AdministrativeDirector(userid);
    }
    void onRefresh(){
        display.displayOff();
        new PatientInformationAdmin(userid);
    }
    void onView(){
        String patientID = jPatientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoReceptionist(query,jName,jAge,jGender,jDateOfAdmission,jDateOfAppointment,jAppointedDoctor,jDateOfRelease,jContactNo,jEmail,jBloodGroup,jPrescription,jPathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

}
