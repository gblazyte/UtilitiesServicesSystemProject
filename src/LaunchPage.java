import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {

    private LaunchPageUI launchPageUI;


    LaunchPage(){
        this.launchPageUI = new LaunchPageUI();
        launchPageUI.getBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = launchPageUI.getBtn();

        if(e.getSource()==button){
            launchPageUI.goToLoginPage();
        }

    }
}
