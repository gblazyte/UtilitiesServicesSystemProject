import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveResidents implements ActionListener {

    RemoveResidentsUI removeResidentsUI = new RemoveResidentsUI();

    RemoveResidents(){
        removeResidentsUI.getRemoveResidentBtn().addActionListener(this);
        removeResidentsUI.getBackBtn().addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton removeResidentBtn = removeResidentsUI.getRemoveResidentBtn();

        if (e.getSource() == removeResidentBtn){
            removeResidentsUI.removeResident();

        } else {
            removeResidentsUI.page.dispose();
            HomePage homePage = new HomePage();
        }

    }
}
