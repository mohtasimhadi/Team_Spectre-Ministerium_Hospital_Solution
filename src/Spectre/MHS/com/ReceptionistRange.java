package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistRange {
    private JPanel contentPanel;
    private JButton logOutButton;
    private JButton patientInformationButton;
    private JButton addNewPatientButton;

    public ReceptionistRange() {
        JFrame jFrame = new JFrame("Pathologist Locale");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                onLogOut();
            }
        });
    }

    void onLogOut(){
        ReceptionistLogin receptionistLogin = new ReceptionistLogin();
    }

    /*public static void main(String[] args){
        ReceptionistRange receptionistRange = new ReceptionistRange();
    }*/
}
