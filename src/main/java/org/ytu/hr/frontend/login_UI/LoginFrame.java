
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class LoginFrame extends JFrame implements ActionListener
{
    Container container;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton;
    JCheckBox showPassword;
    
    public LoginFrame() {
        this.container = this.getContentPane();
        this.userLabel = new JLabel("USERNAME");
        this.passwordLabel = new JLabel("PASSWORD");
        this.userTextField = new JTextField();
        this.passwordField = new JPasswordField();
        this.loginButton = new JButton("LOGIN");
        this.showPassword = new JCheckBox("SHOW PASSWORD");
        this.setLayoutManager();
        this.setLocationandSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }
    
    public void setLayoutManager() {
        this.container.setLayout(null);
    }
    
    public void setLocationandSize() {
        this.userLabel.setBounds(50, 150, 100, 30);
        this.passwordLabel.setBounds(50, 220, 100, 30);
        this.userTextField.setBounds(150, 150, 150, 30);
        this.passwordField.setBounds(150, 220, 150, 30);
        this.showPassword.setBounds(150, 250, 160, 30);
        this.loginButton.setBounds(150, 300, 100, 30);
    }
    
    public void addComponentsToContainer() {
        this.container.add(this.userLabel);
        this.container.add(this.passwordLabel);
        this.container.add(this.userTextField);
        this.container.add(this.passwordField);
        this.container.add(this.showPassword);
        this.container.add(this.loginButton);
    }
    
    public void addActionEvent() {
        this.loginButton.addActionListener(this);
        this.showPassword.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.loginButton) {
            System.out.println(this.userTextField.getText());
            System.out.println(this.passwordField.getPassword());
        }
        if (actionEvent.getSource() == this.showPassword) {
            if (this.showPassword.isSelected()) {
                this.passwordField.setEchoChar('\0');
            }
            else {
                this.passwordField.setEchoChar('*');
            }
        }
    }
}
