package Spectre.MHS.com;

import javax.swing.*;
import Spectre.MHS.com.OperationsNTools.Display;

public class MainLogin {
    private JPanel contentPanel;
    private JComboBox loginType;
    private JButton selectButton;
    private JButton exitButton;

    private final Display display = new Display("Log In Selection", contentPanel);

    public MainLogin() {
        display.displayOn();

        exitButton.addActionListener(e -> onExit());

        
    }

    void onExit(){
        System.exit(0);
    }

}
