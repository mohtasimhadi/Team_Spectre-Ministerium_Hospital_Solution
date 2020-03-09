package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorStation {
    private JPanel contentPanel;
    private JButton logOutButton;
    private JButton viewAppointmentsButton;
    private JButton patientInformationButton;

    public DoctorStation() {
        JFrame jFrame = new JFrame("Doctors Station");
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
        DoctorLogin doctorLogin = new DoctorLogin();
    }

    /*public static void main(String[] args){
        DoctorStation doctorStation = new DoctorStation();
    }*/
}
