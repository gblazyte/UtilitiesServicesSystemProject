import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login implements ActionListener {
    private LoginUI loginUI;

    Login(){
        this.loginUI = new LoginUI();
        loginUI.getLoginBtn().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton loginButton = loginUI.getLoginBtn();

        if (e.getSource() == loginButton){
            loginUI.performLoginAuthentication();
        }

    }
}
