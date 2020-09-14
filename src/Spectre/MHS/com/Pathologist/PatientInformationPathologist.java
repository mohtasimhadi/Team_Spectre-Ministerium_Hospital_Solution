package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.Receptionist.PatientInformationReceptionist;

import javax.swing.*;

public class PatientInformationPathologist {
    private JButton jbackButton;
    private JButton jupdateButton;
    private JButton jrefreshButton;
    private JButton jviewButton;
    private JPanel contentPanel;
    private JTextArea jPathologyTests;
    private JTextField jPatientID;
    private JLabel jName;
    private JLabel jAge;
    private JLabel jGender;
    private JLabel jBloodGroup;
    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationPathologist(String userid) {
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
        display.DisplayOff();
        new PathologistLocale(userid);
    }

    void onRefresh(){
        display.DisplayOff();
        new PatientInformationPathologist(userid);
    }

    void onView(){
        String patientID = jPatientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoPathologist(query,jName,jAge,jGender,jBloodGroup,jPathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String patientID = jPatientID.getText();
        String pathologyTests = jPathologyTests.getText();
        PatientInfo patientInfo = new PatientInfo();
        String query = ("UPDATE patient SET DateOfRelease ='"+pathologyTests+ "' WHERE ID ="+patientID);
        //if(())              //Rafi HELP
        patientInfo.updatePatientInfo(query);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }
}
