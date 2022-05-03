package org.ytu.hr.frontend.loginPage;

import org.ytu.hr.core.services.Login;
import org.ytu.hr.frontend.mainPage.MainPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private Login login;
    public JPanel mainPanel;
    private JPanel topPanel;
    private JLabel Login;
    private JPanel bottomPanel;
    private JPasswordField passwordField1;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JButton loginButton;
    private JTextField usernameField;
    private MainPage mainPage;
    public LoginPage() {
        mainPage = new MainPage();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String username = getUsername();
//                String password = getPassword();

                login = new Login("Evren_Ispir", "12345");

                if(!login.isCorrectUser())
                    JOptionPane.showMessageDialog(null, "Kullanici adi veya sifre yanlis!");
                else {
                    JOptionPane.showMessageDialog(null, "Basarili bir sekilde giris yaptiniz.");
                    mainPage.setVisible(true);
                }
            }
        });
    }
    public String getUsername() {
        return usernameField.getText();
    }
    public String getPassword() {
        return String.valueOf(passwordField1.getPassword());
    }

}
