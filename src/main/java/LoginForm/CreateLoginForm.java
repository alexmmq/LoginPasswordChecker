package LoginForm;

import PasswordCheck.PasswordCheck;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateLoginForm extends JFrame implements ActionListener {
    JButton b1, b2;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    JTextField textField1;
    JPasswordField passwordField;

    CreateLoginForm(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f1 = new Font(Font.SERIF, Font.PLAIN, 24);
        Font f2 = new Font(Font.SERIF, Font.BOLD, 24);

        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setFont(f1);
        textField1 = new JTextField(15);
        textField1.setFont(f1);

        passLabel = new JLabel();
        passLabel.setText("Password");
        passLabel.setFont(f1);
        passwordField = new JPasswordField(15);
        passwordField.setFont(f1);

        b1 = new JButton("Submit");
        b1.setFont(f2);

        b2 = new JButton("Skip");
        b2.setFont(f2);

        newPanel = new JPanel(new GridLayout(3,1, 10, 20));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(passwordField);
        newPanel.add(b1);
        newPanel.add(b2);

        add(newPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        CloseAction closeAction = new CloseAction();
        b2.setAction(closeAction);
        setTitle("Login Form");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String userValue = textField1.getText();
        char[] passValue = passwordField.getPassword();
        try {
            PasswordCheck passwordCheck = new PasswordCheck(passValue);
        } catch (Exception ex) {
            UIManager.put("OptionPane.messageFont", new FontUIResource(
                    new Font("Serif", Font.PLAIN,24)));
            UIManager.put("OptionPane.buttonFont", new FontUIResource(
                    new Font("Serif", Font.PLAIN, 20)));
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public class CloseAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
