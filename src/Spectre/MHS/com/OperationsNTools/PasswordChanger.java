package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChanger {
    private JPasswordField OldPasswordField;
    private JPasswordField NewPasswordField;
    private JButton OKButton;
    private JPanel PasswordChangerPanel;

    public PasswordChanger() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void Display_This(){
        Display display = new Display("Password Changer", PasswordChangerPanel);
        display.displayOn();
        display.changeSize(400, 200);
    }
    public static void main(String[] args) {
       PasswordChanger p = new PasswordChanger();
       p.Display_This();
    }

}
