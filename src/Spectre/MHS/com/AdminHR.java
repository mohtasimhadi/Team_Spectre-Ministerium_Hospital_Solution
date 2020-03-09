package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHR {
    private JButton logOutButton;
    private JPanel contentPanel;
    private JButton viewEmployeeButton;
    private JButton addNewEmployeeButton;

    public AdminHR() {
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
        AdminLogin adminLogin = new AdminLogin();
    }

    /*public static void main(String[] args){
        AdminHR adminHR = new AdminHR();
    }*/
}
