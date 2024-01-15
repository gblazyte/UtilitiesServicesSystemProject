import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateResidents implements ActionListener  {
    private UpdateResidentsUI updateResidentsUI;

    UpdateResidents(String lastName){
        this.updateResidentsUI = new UpdateResidentsUI(lastName);
        updateResidentsUI.getUpdateResidentBtn().addActionListener(this);
        updateResidentsUI.getBackBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton updateResidentBtn = updateResidentsUI.getUpdateResidentBtn();

        if (e.getSource() == updateResidentBtn){
            updateResidentsUI.updateResidents();

        } else {
            updateResidentsUI.page.dispose();
            HomePage homePage = new HomePage();
        }

    }
}

