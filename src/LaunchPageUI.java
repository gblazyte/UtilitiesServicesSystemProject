import javax.swing.*;
import java.awt.*;

public class LaunchPageUI extends MainUI{

    JButton button = new JButton("Click to continue!");
    JLabel headingLabel = new JLabel("Welcome to the utility services website");

    public JButton getBtn() {
        return button;
    }


    LaunchPageUI() {
        super("Main page",1100,650);
        initializeUI();
    }


    private void initializeUI(){
        //label settings
        headingLabel.setFont(new Font("Arial",Font.BOLD, 45));
        headingLabel.setBounds(80,30,1200,60);
        headingLabel.setForeground(Color.darkGray);
        page.getContentPane().add(headingLabel);

        //button settings
        button.setBounds(400,250,300,70);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        page.getContentPane().add(button);
    }

    public void goToLoginPage(){
        page.dispose();
        Login loginWindow = new Login();
    }

}
