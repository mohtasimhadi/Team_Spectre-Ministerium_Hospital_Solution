package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewEmployee {
    private JButton backButton;
    private JButton addEmployeeButton;
    private JPanel contentPanel;


    public AddNewEmployee() {
        JFrame jFrame = new JFrame("Doctors Station");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);
    }
}
