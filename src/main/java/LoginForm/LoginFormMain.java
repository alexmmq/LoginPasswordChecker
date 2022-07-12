package LoginForm;

import javax.swing.*;

public class LoginFormMain {
    public static void main(String[] args){
        try{
            CreateLoginForm createLoginForm = new CreateLoginForm();
            createLoginForm.setSize(300,100);
            createLoginForm.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
